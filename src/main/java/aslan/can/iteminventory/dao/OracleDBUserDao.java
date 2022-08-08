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

    @Override
    public int insertUser(UUID id, User user) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection dbConnection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xepdb1",
                AppProperties.OracleUsername,
                AppProperties.OraclePassword);

            PreparedStatement insertStatement = dbConnection.prepareStatement("INSERT INTO users(user_uuid, username) VALUES('" + id + "', '" + user.getUserName() + "')");
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
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection dbConnection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xepdb1",
                AppProperties.OracleUsername,
                AppProperties.OraclePassword);

            PreparedStatement insertStatement = dbConnection.prepareStatement("SELECT * FROM users");
            ResultSet result = insertStatement.executeQuery();

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
        ArrayList<User> allUsers = new ArrayList<User>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection dbConnection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/xepdb1",
                AppProperties.OracleUsername,
                AppProperties.OraclePassword);

            PreparedStatement insertStatement = dbConnection.prepareStatement("SELECT * FROM users WHERE user_uuid='" + id + "'");
            ResultSet result = insertStatement.executeQuery();

            while ( result.next() ) {
                allUsers.add(new User(UUID.fromString(result.getString(2)), result.getString(3)));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return allUsers.stream().findFirst();
    }

    @Override
    public int deleteUserByID(UUID id) {
        /*
        Optional<User> userToDelete = selectUserByID(id);

        // If the specified user is not found, return 0
        if (userToDelete.isEmpty()) return 0;

        // Delete the specified user
        DB.remove(userToDelete.get());
        return 1;
        */
        return 0;
    }

    @Override
    public int updateUserByID(UUID id, User user) {
        /*
        return selectUserByID(id).map(userToUpdate -> {
            int indexOfUserToUpdate = DB.indexOf(userToUpdate);
            if (indexOfUserToUpdate < 0) return 0; // If userToUpdate is not found, return 0

            // Update user
            DB.set(indexOfUserToUpdate, new User(id, user.getUserName()));

            return 1;
        }).orElse(0);
        */
        return 0;
    }
}
