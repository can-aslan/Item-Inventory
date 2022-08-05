package aslan.can.iteminventory.api;

import aslan.can.iteminventory.model.User;
import aslan.can.iteminventory.service.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void addUser(User user) {
        userService.addUser(user);
    }
}
