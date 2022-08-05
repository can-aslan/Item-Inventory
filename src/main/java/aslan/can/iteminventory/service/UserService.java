package aslan.can.iteminventory.service;

import aslan.can.iteminventory.dao.UserDao;
import aslan.can.iteminventory.model.User;

public class UserService {
    
    private final UserDao userDao;
    
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user) {
        return userDao.insertUser(user);
    }
}
