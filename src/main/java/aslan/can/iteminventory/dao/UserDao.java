package aslan.can.iteminventory.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import aslan.can.iteminventory.model.User;

public interface UserDao {
    int insertUser(UUID id, User user);
    default int insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> getAllUsers();
    Optional<User> selectUserByID(UUID id);
    int deleteUserByID(UUID id);
    int updateUserByID(UUID id, User user);
}
