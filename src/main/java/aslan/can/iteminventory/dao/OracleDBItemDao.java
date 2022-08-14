package aslan.can.iteminventory.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import aslan.can.iteminventory.model.Item;
import org.springframework.stereotype.Repository;
import java.sql.*;

@Repository("oracle-item")
public class OracleDBItemDao implements ItemDao {

    public static Connection dbConnection;

    public static void establishConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            dbConnection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xepdb1",
                AppProperties.OracleUsername,
                AppProperties.OraclePassword);
            
            try {
                PreparedStatement tableAccessStatement = dbConnection.prepareStatement(
                    "SELECT * FROM items");
                tableAccessStatement.executeQuery();
            }
            catch (SQLSyntaxErrorException e) {
                e.printStackTrace();
                PreparedStatement createTableStatement = dbConnection.prepareStatement(
                    "CREATE TABLE items(task_id NUMBER GENERATED BY DEFAULT AS IDENTITY, owner_uuid VARCHAR2(63), task_title VARCHAR2(63), task_desc VARCHAR2(255), task_category VARCHAR2(63), PRIMARY KEY(task_id))");
                    createTableStatement.executeQuery();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertItem(UUID ownerUUID, Item item) {
        try {
            PreparedStatement insertStatement = dbConnection.prepareStatement(
                "INSERT INTO items(owner_uuid, task_title, task_desc, task_category) VALUES('"
                + ownerUUID + "', '"
                + item.getTitle() + "', '"
                + item.getDesc() + "', '"
                + item.getCategory() + "')");
            insertStatement.executeQuery();
            return 1;
        }
        catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Item> getAllItems() {
        ArrayList<Item> allItems = new ArrayList<Item>();

        try {
            PreparedStatement getAllItemsStatement = dbConnection.prepareStatement(
                "SELECT * FROM items");
            ResultSet result = getAllItemsStatement.executeQuery();

            while ( result.next() ) {
                System.out.println("------ITEM ADDED-------");
                System.out.println("OwnerUUID: " + result.getString(2));
                System.out.println("Title: " + result.getString(3));
                System.out.println("Description: " + result.getString(4));
                System.out.println("Category: " + result.getString(5));
                System.out.println("------ITEM ADDED-------");
                allItems.add(new Item(  UUID.fromString(result.getString(2)),
                                        result.getString(3),
                                        result.getString(4),
                                        result.getString(5)));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return allItems;
    }

    @Override
    public Optional<Item> selectItemByID(UUID itemID) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public int deleteItemByID(UUID itemID) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateItemByID(UUID itemID, Item newItem) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
