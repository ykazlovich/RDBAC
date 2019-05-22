package RDBAC.controller;

import RDBAC.model.Item;
import RDBAC.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = ItemRestController.REST_ITEM_URL)
@CrossOrigin
public class ItemRestController {

    final static String REST_ITEM_URL = "/v1/items";

    @Autowired
    private ItemService service;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> findByModelOrSerialNumber(@RequestParam String search){
        return service.findByModelOrSerialNumber(search);
    }

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Item getById(@PathVariable int id){
        return service.get(id);
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAll(){
        return service.getAll();
    }

    @PostMapping(path = "/")
    public Item save(@RequestBody Item item){
        return service.save(item);
    }


}
