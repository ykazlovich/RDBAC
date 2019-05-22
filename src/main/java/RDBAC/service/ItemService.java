package RDBAC.service;

import RDBAC.model.Item;

import java.util.List;

public interface ItemService {
    Item get(int id);
    List<Item> getAll();
    Item save(Item item);
    List<Item> findByModelOrSerialNumber(String search);
}
