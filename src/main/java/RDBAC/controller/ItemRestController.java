package RDBAC.controller;

import RDBAC.model.Item;
import RDBAC.service.ItemService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = ItemRestController.REST_ITEM_URL)
@CrossOrigin
public class ItemRestController {

    final static String REST_ITEM_URL = "/v1/items";

    @Autowired
    private ItemService service;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> findByModelOrSerialNumber(@RequestParam String search) {
        return service.findByModelOrSerialNumber(search);
    }

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getById(@PathVariable int id) {
        return Optional
                .ofNullable(service.get(id))
                .map(item -> ResponseEntity.ok().body(item))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Item>> getAll() {
        List<Item> entities = service.getAll();
        return Optional.of(entities)
                .map(items -> ResponseEntity.status(HttpStatus.OK).body(items))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/")
    public ResponseEntity<Item> save(@RequestBody Item item) {
        Item save = service.save(item);
        return Optional.ofNullable(save)
                .map(i -> ResponseEntity.created(ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path(REST_ITEM_URL + "/{id}")
                        .buildAndExpand(i.getId())
                        .toUri())
                        .body(i))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }


}
