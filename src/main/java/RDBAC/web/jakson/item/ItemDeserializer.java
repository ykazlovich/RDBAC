package RDBAC.web.jakson.item;

import RDBAC.model.Item;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class ItemDeserializer extends StdDeserializer<Item> {
    public ItemDeserializer() {
        super(Item.class);
    }

    @Override
    public Item deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Item item = new Item();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        //item.setObjectId(new ObjectId("item", "pk", Integer.valueOf(jsonParser.getValueAsString("id"))));
        item.setIname(node.get("iname").asText());
        item.setSerialno(node.get("serialnumber").asText());
        return item;
    }
}
