package RDBAC.web.jakson.order;

import RDBAC.model.Client;
import RDBAC.model.Item;
import RDBAC.model.Order;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.cayenne.ObjectId;
import org.apache.cayenne.PersistenceState;

import java.io.IOException;

public class OrderDeserializer extends StdDeserializer<Order> {

    public OrderDeserializer(){
        this(null);
    }
    public OrderDeserializer(Class<Order> t){
        super(t);
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
