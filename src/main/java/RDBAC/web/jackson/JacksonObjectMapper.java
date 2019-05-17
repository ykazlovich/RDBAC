package RDBAC.web.jackson;

import RDBAC.model.Client;
import RDBAC.model.Item;
import RDBAC.model.Order;
import RDBAC.web.jackson.client.ClientDeserializer;
import RDBAC.web.jackson.client.ClientSerializer;
import RDBAC.web.jackson.item.ItemDeserializer;
import RDBAC.web.jackson.item.ItemSerializer;
import RDBAC.web.jackson.order.OrderDeserializer;
import RDBAC.web.jackson.order.OrderSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JacksonObjectMapper extends ObjectMapper {

    private static final ObjectMapper MAPPER = new JacksonObjectMapper();

    private JacksonObjectMapper() {
        SimpleModule simpleModule = new SimpleModule()
                .addSerializer(Order.class, new OrderSerializer())
                .addDeserializer(Order.class, new OrderDeserializer())
                .addSerializer(Item.class, new ItemSerializer())
                .addDeserializer(Item.class, new ItemDeserializer())
                .addSerializer(Client.class, new ClientSerializer())
                .addDeserializer(Client.class, new ClientDeserializer());
        this.registerModule(simpleModule);
    }

    public static ObjectMapper getMapper() {
        return MAPPER;
    }
}