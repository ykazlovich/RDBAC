package RDBAC.repository;

import RDBAC.ClientTestData;
import RDBAC.model.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration({"classpath:/spring.xml", "classpath:/spring-db-test.xml"})
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class ClientRepositoryImplTest {

    @Autowired
    private ClientRepository repository;

    @Test
    void get() {
        Client clint1FromDb = repository.get(1);
        assertEquals(ClientTestData.testClientList.get(0), clint1FromDb);
    }

    @Test
    void getAll() {
        List<Client> clientsListFromDb = repository.getAll();
        assertIterableEquals(ClientTestData.testClientList, clientsListFromDb);
    }

    @Test
    void findClientByName() {
        List<Client> clientsListFromDb = repository.findByNameAndPhone("Koval Alexander");
        assertEquals(ClientTestData.testClientList.get(2), clientsListFromDb.get(0));
    }

    @Test
    void findClientByPhoneNumberWithoutCountryCode() {
        List<Client> clientsListFromDb = repository.findByNameAndPhone("97777777");
        assertEquals(ClientTestData.testClientList.get(1), clientsListFromDb.get(0));
    }

    @Test
    void findByNameUsingDifferentLetterCase() {
        List<Client> clientsListFromDb = repository.findByNameAndPhone("KOVal AlEXandEr");
        assertEquals(ClientTestData.testClientList.get(2), clientsListFromDb.get(0));
    }

    @Test
    void findByNameNotExistClient() {
        List<Client> clientsListFromDb = repository.findByNameAndPhone("Alex Frew");
        assertEquals(0, clientsListFromDb.size());
    }



    @Test
    void save() {
    }
}