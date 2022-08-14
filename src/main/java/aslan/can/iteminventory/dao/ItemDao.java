package aslan.can.iteminventory.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import aslan.can.iteminventory.model.Item;

public interface ItemDao {
    int insertItem(UUID ownerUUID, Item item);
    List<Item> getAllItems();
    Optional<Item> getItemsOfUserByID(UUID itemID);
    int deleteItemByID(UUID itemID);
}
