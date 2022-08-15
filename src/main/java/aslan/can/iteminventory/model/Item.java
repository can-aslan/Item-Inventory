package aslan.can.iteminventory.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    
    private final UUID taskUUID;
    private final UUID ownerUUID;
    private final String title;
    private final String desc;
    private final String category;

    // For output only
    public Item(UUID taskUUID, UUID ownerUUID, String title, String desc, String category) {
        this.taskUUID = taskUUID;
        this.ownerUUID = ownerUUID;
        this.title = title;
        this.desc = desc;
        this.category = category;
    }  

    // For output only (users without items)
    public Item(String category) {
        this.taskUUID = null;
        this.ownerUUID = null;
        this.title = "The specified user has no items.";
        this.desc = "The specified user has no items.";
        this.category = category;
    }  

    public Item(@JsonProperty("ownerUUID") UUID ownerUUID,
                @JsonProperty("title") String title,
                @JsonProperty("desc") String desc,
                @JsonProperty("category") String category) {
        
        this.taskUUID = UUID.randomUUID();
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
