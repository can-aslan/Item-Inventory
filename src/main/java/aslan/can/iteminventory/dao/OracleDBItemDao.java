package aslan.can.iteminventory.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import aslan.can.iteminventory.model.Item;
import aslan.can.iteminventory.model.User;

public class OracleDBItemDao implements ItemDao {

    @Override
    public int insertItem(User owner, Item item) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Item> getAllItems() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Item> selectItemByID(UUID itemID) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public int deleteItemByID(UUID itemID) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateItemByID(UUID itemID, Item newItem) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
