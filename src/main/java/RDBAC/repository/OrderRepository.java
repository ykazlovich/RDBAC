package RDBAC.repository;

import RDBAC.model.Order;

import java.util.List;

public interface OrderRepository {
    Order get(int id);
    List<Order> getAll();
    Order save(Order order);
}
