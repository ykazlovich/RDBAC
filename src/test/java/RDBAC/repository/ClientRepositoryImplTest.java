package RDBAC.repository;

import RDBAC.model.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration({"classpath:/spring.xml", "classpath:/spring-db-test.xml"})
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class ClientRepositoryImplTest {

    @Autowired
    private ClientRepository repository;

    @Test
    void get() {
        Client client = new Client();
        client.setId(1);
        client.setName("Ivanov Viktor");
        client.setPhone("+375291111111");
        Client clint1FromDb = repository.get(1);
        assertEquals(client, clint1FromDb);
    }

    @Test
    void findByNameAndPhone() {
    }

    @Test
    void getAll() {
    }

    @Test
    void save() {
    }
}