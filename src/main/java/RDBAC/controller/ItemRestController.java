package RDBAC.controller;

import RDBAC.model.Item;
import RDBAC.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/items")
@CrossOrigin
public class ItemRestController {

    @Autowired
    private ItemRepository repository;

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Item getById(@PathVariable int id){
        return repository.get(id);
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAll(){
        return repository.getAll();
    }

    @PostMapping(path = "/")
    public Item save(@RequestBody Item item){
        System.out.println("postmapping works");
        return repository.save(item);
    }


}
