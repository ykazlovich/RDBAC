package RDBAC.controller;

import RDBAC.model.Client;
import RDBAC.model.Item;
import RDBAC.model.Order;
import RDBAC.web.jakson.JacksonObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cayenne.ObjectId;
import org.apache.cayenne.PersistenceState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(value = "/spring.xml")
class OrderRestControllerImplTest {

    @Autowired
    private OrderRestControllerImpl controller;

    @Test
    void getOrderById() throws Exception {
        ObjectMapper mapper = JacksonObjectMapper.getMapper();


        Client client = new Client();
        client.setObjectId(new ObjectId("client", "id", 1));
        System.out.println(client);


    }

    @Test
    void getAllOrder() {
        controller.getAllOrder();
    }
}