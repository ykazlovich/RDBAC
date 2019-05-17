package RDBAC.repository;

import RDBAC.ItemTestData;
import RDBAC.model.Order;
import org.apache.cayenne.PersistenceState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(value = {"/spring.xml", "/spring-db-test.xml"})
class OrderRepositoryImplTest {

    @Autowired
    OrderRepository repository;

    @Test
    void getById() {
        Order order = repository.get(1);


    }

    @org.junit.jupiter.api.Test
    void getAll() {
        Order order = new Order();
        System.out.println(PersistenceState.persistenceStateName(order.getPersistenceState()));
        System.out.println(repository.getAll());
    }

}