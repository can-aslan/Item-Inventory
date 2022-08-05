package aslan.can.iteminventory.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    
    private final UUID id;
    private final String userName;

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("userName") String userName) {
        this.id = id;
        this.userName = userName;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
}
