package aslan.can.iteminventory.model;

import java.util.ArrayList;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    
    private final UUID id;
    private final String userName;
    // private ArrayList<String> items;

    /*
    public User() {
        id = null;
        userName = "null";
        items = null;
    }
    */

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("userName") String userName) {
        this.id = id;

        if (userName == null || userName.isEmpty()) {
            this.userName = "No Username Provided";
        }
        else {
            this.userName = userName;
        }

        // items = new ArrayList<String>();
    }

    /* 
    public User(@JsonProperty("id") UUID id,
                @JsonProperty("userName") String userName,
                @JsonProperty("items") ArrayList<String> items) {
        this.id = id;

        if (userName == null || userName.isEmpty()) {
            this.userName = "No Username Provided";
        }
        else {
            this.userName = userName;
        }

        this.items = items;
    }
    */

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    /*
    public void addItem(String item) {
        items.add(item);
    }

    public boolean removeItem(String item) {
        int removeIndex = -1;

        if (!items.stream().filter(potentialItemToRemove -> potentialItemToRemove.equals(item)).findFirst().isEmpty()) {
            items.remove(item);
            return true;
        }

        return false;
    }
    */
}
