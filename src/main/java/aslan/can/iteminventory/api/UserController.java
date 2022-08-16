package aslan.can.iteminventory.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aslan.can.iteminventory.model.Item;
import aslan.can.iteminventory.model.User;
import aslan.can.iteminventory.service.ItemService;
import aslan.can.iteminventory.service.UserService;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserService userService;
    private final ItemService itemService;

    @Autowired
    public UserController(UserService userService, ItemService itemService) {
        this.userService = userService;
        this.itemService = itemService;
    }

    // ###########################
    // ###### USER REQUESTS ######
    // ###########################
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User " + user.getUserName() + " added successfully.";
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "{id}")
    public User getUserByID(@PathVariable("id") UUID id) {
        return userService.getUserByID(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public String deleteUserByID(@PathVariable("id") UUID id) {
        if (userService.deleteUserByID(id) == 1) return "User with UUID '" + id + "' deleted successfully.";
        return "ERROR: Could not delete user with UUID '" + id + "'.";
    }

    @PutMapping(path = "{id}")
    public String updateUser(@PathVariable("id") UUID id, @RequestBody User newUser) {
        if (userService.updateUserByID(id, newUser) == 1) return "User with UUID '" + id + "' updated successfully.";
        return "ERROR: Could not update user with UUID '" + id + "'.";
    }
    // ###############################
    // ###### USER REQUESTS END ######
    // ###############################

    // ##################################
    // ###### TASK (ITEM) REQUESTS ######
    // ##################################
    @PostMapping(path = "items/{ownerUUID}/add")
    public String addItem(@PathVariable("ownerUUID") UUID ownerUUID, @RequestBody Item item) {
        itemService.addItem(ownerUUID, item);
        return "Item added successfully.";
    }

    @GetMapping(path = "items/{ownerUUID}")
    public List<Item> getItemsOfUserByID(@PathVariable("ownerUUID") UUID ownerUUID) {
        return itemService.getItemsOfUserByID(ownerUUID);
    }

    @GetMapping(path = "items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @DeleteMapping(path = "items/del/{taskUUID}")
    public String deleteItemByID(@PathVariable("taskUUID") UUID taskUUID) {
        if (itemService.deleteItemByID(taskUUID) == 1) return "Task with UUID '" + taskUUID + "' deleted successfully if it exists in the database.";
        return "ERROR: Could not delete task with UUID '" + taskUUID + "'.";
    }

    @GetMapping(path = "items/category/{category}")
    public List<Item> getAllItemsByCategory(@PathVariable("category") String category) {
        return itemService.getAllItemsByCategory(category);
    }
    // ######################################
    // ###### TASK (ITEM) REQUESTS END ######
    // ######################################
}
