package RDBAC.service;

import RDBAC.model.Order;
import RDBAC.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public Order get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = repository.getAll();
        orders.sort((x, y) -> x.getId() > y.getId() ? -1 : 0);
        return orders;
    }

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }
}
