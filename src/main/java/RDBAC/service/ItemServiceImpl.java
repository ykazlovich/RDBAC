package RDBAC.service;

import RDBAC.model.Item;
import RDBAC.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    public List<Item> findByModelOrSerialNumber(String search) {
        return repository.findByModelOrSerialNumber(search);
    }

    @Override
    public Item get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Item> getAll() {
        return repository.getAll();
    }

    @Override
    public Item save(Item item) {
        return repository.save(item);
    }
}
