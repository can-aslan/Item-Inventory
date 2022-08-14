package aslan.can.iteminventory.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Items {

    private final ArrayList<Item>

    public Items(@JsonProperty("id") UUID id,
                @JsonProperty("userName") String userName) {
    }
}
