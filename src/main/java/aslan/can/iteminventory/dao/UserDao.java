package aslan.can.iteminventory.dao;

import java.util.UUID;
import aslan.can.iteminventory.model.User;

public interface UserDao {
    int insertUser(UUID id, User user);

    default int addUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }
}
