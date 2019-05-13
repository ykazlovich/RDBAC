package RDBAC.service;

import RDBAC.model.Order;

import java.util.List;

public interface OrderService {
    Order get(int id);
    List<Order> getAll();
    Order save(Order order);
}
