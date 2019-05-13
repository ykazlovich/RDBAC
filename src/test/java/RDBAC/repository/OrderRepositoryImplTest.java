package RDBAC.repository;

import RDBAC.model.Item;
import RDBAC.model.Order;
import org.apache.cayenne.PersistenceState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(value = "/spring.xml")
class OrderRepositoryImplTest {

    @Autowired
    OrderRepository repository;

    @org.junit.jupiter.api.Test
    void getAll() {
        Order order = new Order();
        System.out.println(PersistenceState.persistenceStateName(order.getPersistenceState()));
        System.out.println(repository.getAll());
    }

    @org.junit.jupiter.api.Test
    void getById() {
        Order order = repository.get(39);
        System.out.println(PersistenceState.persistenceStateName(order.getPersistenceState()));

        System.out.println(PersistenceState.persistenceStateName(order.getPersistenceState()));
    }

    @Test
    void t(){
        Order order = repository.get(39);
        Item item = order.getItem();
        System.out.println(order);

        System.out.println(item);
    }

    @Test
    void save() {
        Order order = new Order();
        System.out.println("New order id = " + order.getObjectId());

        repository.save(order);
        System.out.println(order.getOrderId());
    }
}