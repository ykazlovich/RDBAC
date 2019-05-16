package RDBAC.controller;

import RDBAC.model.Client;
import RDBAC.repository.ClientRepository;
import RDBAC.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/clients")
@CrossOrigin
public class ClientRestController {
    @Autowired
    private ClientService service;


    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> getAll(){
        return service.getAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client get(@PathVariable int id){
        return service.get(id);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> save(@RequestBody Client client){
        Client save = service.save(client);
        ResponseEntity<Client> o = new ResponseEntity<>(save, HttpStatus.CREATED);
        return o;
    }

    @PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> update(@RequestBody Client client){
        System.out.println("postmapping works");
        System.out.println(client);
        Client updated = service.save(client);
        ResponseEntity<Client> o = new ResponseEntity<>(updated, HttpStatus.OK);
        return o;
    }



}
