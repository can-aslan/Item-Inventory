package aslan.can.iteminventory.dao;

import java.util.ArrayList;
import java.util.UUID;
import aslan.can.iteminventory.model.User;

public class FakeUserDataAccessService implements UserDao {

    private static ArrayList<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getUserName()));
        return 1;
    }
    
}
