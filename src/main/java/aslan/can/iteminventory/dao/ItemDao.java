package aslan.can.iteminventory.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import aslan.can.iteminventory.model.Item;

public interface ItemDao {
    int insertItem(UUID ownerUUID, Item item);
    default int insertItem(UUID ownerUUID, String title, String desc, String category) {
        return insertItem(ownerUUID, new Item(UUID.randomUUID(), ownerUUID, title, desc, category));
    }

    List<Item> getAllItems();
    Optional<Item> selectItemByID(UUID itemID);
    int deleteItemByID(UUID itemID);
    int updateItemByID(UUID itemID, Item newItem);
}
