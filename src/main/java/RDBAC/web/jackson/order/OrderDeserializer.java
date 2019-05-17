package RDBAC.web.jackson.order;

import RDBAC.model.Order;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class OrderDeserializer extends StdDeserializer<Order> {

    public OrderDeserializer(){
        super(Order.class);
    }

    @Override
    public Order deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Order order = new Order();

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        JsonNode jsonClientNode = node.get("client");
        JsonNode jsonItemNode = node.get("item");

        order.setTempItemId(jsonItemNode.get("id").asInt());
        order.setTempClientId(jsonClientNode.get("id").asInt());

        order.setDescription(node.get("description").asText());
        return order;
    }
}
