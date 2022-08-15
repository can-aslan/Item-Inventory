package aslan.can.iteminventory.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import aslan.can.iteminventory.model.User;

@Deprecated
@Repository("arrayList-user")
public class ArrayListUserDao implements UserDao {

    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getUserName()));
        return 1;
    }

    @Override
    public List<User> getAllUsers() {
        return DB;
    }

    @Override
    public Optional<User> selectUserByID(UUID id) {
        return DB.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteUserByID(UUID id) {
        Optional<User> userToDelete = selectUserByID(id);

        // If the specified user is not found, return 0
        if (userToDelete.isEmpty()) return 0;

        // Delete the specified user
        DB.remove(userToDelete.get());
        return 1;
    }

    @Override
    public int updateUserByID(UUID id, User user) {
        return selectUserByID(id).map(userToUpdate -> {
            int indexOfUserToUpdate = DB.indexOf(userToUpdate);
            if (indexOfUserToUpdate < 0) return 0; // If userToUpdate is not found, return 0

            // Update user
            DB.set(indexOfUserToUpdate, new User(id, user.getUserName()));

            return 1;
        }).orElse(0);
    }
}
