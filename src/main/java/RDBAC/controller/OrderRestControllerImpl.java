package RDBAC.controller;

import RDBAC.model.Order;
import RDBAC.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = OrderRestControllerImpl.REST_ORDER_URL)
@CrossOrigin
public class OrderRestControllerImpl {

    static final String REST_ORDER_URL = "/v1/orders";

    @Autowired
    private OrderService service;

    @RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getAllOrder() {
        List<Order> orders = service.getAll();
        return Optional.ofNullable(orders)
                .map(o -> ResponseEntity.status(HttpStatus.OK).body(o))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @RequestMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrderById(@PathVariable(name = "id") int id) {
        Order order = service.get(id);
        return Optional.ofNullable(order)
                .map(o -> ResponseEntity.status(HttpStatus.OK).body(o))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> save(@RequestBody Order order) {
        Order addedOrder = service.save(order);
        return Optional.ofNullable(addedOrder)
                .map(o -> ResponseEntity.created(ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path(REST_ORDER_URL + "/{id}").build().toUri()).body(o))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }


}
