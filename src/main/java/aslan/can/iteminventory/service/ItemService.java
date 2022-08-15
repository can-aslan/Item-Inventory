package aslan.can.iteminventory.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import aslan.can.iteminventory.dao.ItemDao;
import aslan.can.iteminventory.model.Item;

@Service
public class ItemService {
    
    private final ItemDao itemDao;
    
    @Autowired
    public ItemService(@Qualifier("oracle-item") ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public int addItem(UUID ownerUUID, Item item) {
        return itemDao.insertItem(ownerUUID, item);
    }

    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }

    public List<Item> getItemsOfUserByID(UUID ownerUUID) {
        return itemDao.getItemsOfUserByID(ownerUUID);
    }
}
