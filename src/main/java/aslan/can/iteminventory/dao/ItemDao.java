package aslan.can.iteminventory.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import aslan.can.iteminventory.model.Item;
import aslan.can.iteminventory.model.User;

public interface ItemDao {
    int insertItem(User owner, Item item);
    List<Item> getAllItems();
    Optional<Item> selectItemByID(UUID itemID);
    int deleteItemByID(UUID itemID);
    int updateItemByID(UUID itemID, Item newItem);
}
