package RDBAC.web.jackson.item;

import RDBAC.model.Item;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ItemSerializer extends StdSerializer<Item> {

    public ItemSerializer(){
        super(Item.class);
    }

    @Override
    public void serialize(Item item, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", item.getId());
        jsonGenerator.writeStringField("iname", item.getIname());
        jsonGenerator.writeStringField("serialnumber", item.getSerialno());
        jsonGenerator.writeEndObject();
    }
}
