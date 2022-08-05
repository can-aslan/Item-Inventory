package aslan.can.iteminventory.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public Optional<User> getUserByID(UUID id) {
        return userDao.selectUserByID(id);
    }
}
