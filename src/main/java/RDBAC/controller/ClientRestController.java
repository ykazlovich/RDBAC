package RDBAC.controller;

import RDBAC.model.Client;
import RDBAC.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = ClientRestController.REST_CLIENT_URL)
@CrossOrigin
public class ClientRestController {

    final static String REST_CLIENT_URL = "/v1/clients";

    @Autowired
    private ClientService service;


    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> getAll() {
        List<Client> clients = service.getAll();
        return Optional.ofNullable(clients)
                .map(c -> ResponseEntity.status(HttpStatus.OK).body(c))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> get(@PathVariable int id) {
        Client client = service.get(id);
        return Optional.ofNullable(client)
                .map(c -> ResponseEntity.status(HttpStatus.OK).body(c))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> searchClientByNameAndPhone(@RequestParam(value = "search") String search) {
        List<Client> clients = service.findByNameAndPhone(search);
        return Optional.ofNullable(clients)
                .map(c -> ResponseEntity.status(HttpStatus.OK).body(c))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> save(@RequestBody Client client) {
        Client save = service.save(client);
        return Optional.ofNullable(save)
                .map(c -> ResponseEntity.created(ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path(REST_CLIENT_URL + "/{id}").build().toUri()).body(c))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> update(@RequestBody Client client) {
        Client updated = service.save(client);
        ResponseEntity<Client> o = new ResponseEntity<>(updated, HttpStatus.OK);
        return o;
    }


}
