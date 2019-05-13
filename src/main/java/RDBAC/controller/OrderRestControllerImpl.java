package RDBAC.controller;

import RDBAC.model.Order;
import RDBAC.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/orders")
@CrossOrigin
public class OrderRestControllerImpl {

    @Autowired
    private OrderService service;

    @RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getAllOrder() {
        return service.getAll();
    }

    @RequestMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrderById(@PathVariable(name = "id") int id) {
        return service.get(id);
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> save(@RequestBody Order order){
        System.out.println(order.getDescription());
        Order addedOrder = service.save(order);
        ResponseEntity<Order> o = new ResponseEntity<>(addedOrder, HttpStatus.CREATED);
        return o;
    }


}
