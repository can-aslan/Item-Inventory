package aslan.can.iteminventory.model;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    
    private final UUID id;
    private final String userName;

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("userName") String userName) {
        this.id = id;

        if (userName == null || userName.isEmpty()) {
            this.userName = "No Username Provided";
        }
        else {
            this.userName = userName;
        }
    }

    public UUID getId() {
        return this.id;
    }

    public String getUserName() {
        return this.userName;
    }
}
