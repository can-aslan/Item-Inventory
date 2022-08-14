package aslan.can.iteminventory.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    
    private final UUID ownerUUID;
    private final UUID taskUUID;
    private final String title;
    private final String desc;
    private final String category;

    public Item(@JsonProperty("taskUUID") UUID taskUUID,
                @JsonProperty("ownerUUID") UUID ownerUUID,
                @JsonProperty("title") String title,
                @JsonProperty("desc") String desc,
                @JsonProperty("category") String category) {

        this.taskUUID = taskUUID;
        this.ownerUUID = ownerUUID;
        this.category = category.toLowerCase();

        if (title == null || title.isEmpty()) this.title = "No Title Provided";
        else this.title = title;

        if (desc == null || desc.isEmpty()) this.desc = "No Description Provided";
        else this.desc = desc;
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

    public String getCategory() {
        return this.category;
    }

    public UUID getTaskUUID() {
        return this.taskUUID;
    }
}
