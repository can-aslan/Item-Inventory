package aslan.can.iteminventory.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    
    private final UUID ownerUUID;
    private final UUID taskUUID;
    private final String title;
    private final String desc;
    private final int category;

    public Item(@JsonProperty("ownerUUID") UUID ownerUUID,
                @JsonProperty("taskUUID") UUID taskUUID,
                @JsonProperty("title") String title,
                @JsonProperty("desc") String desc,
                @JsonProperty("category") int category) {

        this.ownerUUID = ownerUUID;
        this.taskUUID = taskUUID;

        if (title == null || title.isEmpty()) this.title = "No Title Provided";
        else this.title = title;

        if (desc == null || desc.isEmpty()) this.desc = "No Description Provided";
        else this.desc = desc;

        if (category > 10) this.category = -1;
        else this.category = category;
    }

    public UUID getOwnerUUID() {
        return this.ownerUUID;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getCategory() {
        return this.category;
    }

    public UUID getTaskUUID() {
        return this.taskUUID;
    }
}
