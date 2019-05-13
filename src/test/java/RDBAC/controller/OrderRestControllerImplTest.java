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

//        Order order = controller.getOrderById(1);
//        Item item = order.getItem();
//        System.out.println(PersistenceState.persistenceStateName(item.getPersistenceState()));
//        System.out.println(item);
//        System.out.println(PersistenceState.persistenceStateName(item.getPersistenceState()));

        //File file = new File("C:/0DEL/order.json");
        //mapper.writeValue(file, order);
//        File file2 = new File("C:/0DEL/order.json");
//        InputStreamReader in = new InputStreamReader(new FileInputStream(file2));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
//        String jsonString = bufferedReader.readLine();
//                //"{\"description\":\"descon39test\"}";
//
//        Order order1 = mapper.readValue(jsonString, Order.class);
//        controller.save(order1);
        //System.out.println(order1.getTempItemId());
        Client client = new Client();
        client.setObjectId(new ObjectId("client", "id", 1));
        System.out.println(client);


    }

    @Test
    void getAllOrder() {
        controller.getAllOrder();
    }
}