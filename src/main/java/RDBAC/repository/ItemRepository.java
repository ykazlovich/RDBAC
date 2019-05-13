package RDBAC.repository;

import RDBAC.model.Item;

import java.util.List;

public interface ItemRepository {
    Item get(int id);
    List<Item> getAll();
    Item save(Item item);
}
