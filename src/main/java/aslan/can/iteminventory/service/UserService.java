package aslan.can.iteminventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import aslan.can.iteminventory.dao.UserDao;
import aslan.can.iteminventory.model.User;

@Service
public class UserService {
    
    private final UserDao userDao;
    
    @Autowired
    public UserService(@Qualifier("fakeDao") UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user) {
        return userDao.insertUser(user);
    }
}
