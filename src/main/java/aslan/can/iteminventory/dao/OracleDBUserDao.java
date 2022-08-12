package aslan.can.iteminventory.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import aslan.can.iteminventory.model.User;
import java.sql.*;

@Repository("oracle")
public class OracleDBUserDao implements UserDao {

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
                    "SELECT * FROM users");
                tableAccessStatement.executeQuery();
            }
            catch (SQLSyntaxErrorException e) {
                e.printStackTrace();
                PreparedStatement createTableStatement = dbConnection.prepareStatement(
                    "CREATE TABLE users(user_id NUMBER GENERATED BY DEFAULT AS IDENTITY, user_uuid VARCHAR2(63), username VARCHAR2(255), PRIMARY KEY(user_id))");
                    createTableStatement.executeQuery();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertUser(UUID id, User user) {
        try {
            PreparedStatement insertStatement = dbConnection.prepareStatement(
                "INSERT INTO users(user_uuid, username) VALUES('" + id + "', '" + user.getUserName() + "')");
            insertStatement.executeQuery();
            return 1;
        }
        catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<User> getAllUsers() {
        ArrayList<User> allUsers = new ArrayList<User>();

        try {
            PreparedStatement getAllUsersStatement = dbConnection.prepareStatement(
                "SELECT * FROM users");
            ResultSet result = getAllUsersStatement.executeQuery();

            while ( result.next() ) {
                allUsers.add(new User(UUID.fromString(result.getString(2)), result.getString(3)));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return allUsers;
    }

    @Override
    public Optional<User> selectUserByID(UUID id) {
        ArrayList<User> selectedUser = new ArrayList<User>();

        try {
            PreparedStatement selectUserByIDStatement = dbConnection.prepareStatement(
                "SELECT * FROM users WHERE user_uuid='" + id + "'");
            ResultSet result = selectUserByIDStatement.executeQuery();

            while ( result.next() ) {
                selectedUser.add(new User(UUID.fromString(result.getString(2)), result.getString(3)));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return selectedUser.stream().findFirst();
    }

    @Override
    public int deleteUserByID(UUID id) {
        // If the user does not exist, return 0
        if (selectUserByID(id).isEmpty()) {
            return 0;
        }
        
        try {
            PreparedStatement deleteStatement = dbConnection.prepareStatement(
                "DELETE FROM users WHERE users.user_uuid='" + id + "'");
            deleteStatement.executeQuery();
            return 1;
        }
        catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateUserByID(UUID id, User user) {
        // If the user does not exist, return 0
        if (selectUserByID(id).isEmpty()) {
            return 0;
        }

        try {
            PreparedStatement updateStatement = dbConnection.prepareStatement(
                "UPDATE users SET users.username='" + user.getUserName() + "' WHERE users.user_uuid='" + id + "'");
            updateStatement.executeQuery();
            return 1;
        }
        catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}