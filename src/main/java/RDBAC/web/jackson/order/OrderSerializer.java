package RDBAC.web.jackson.order;

import RDBAC.model.Order;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class OrderSerializer extends StdSerializer<Order> {

    public OrderSerializer() {
        super(Order.class);
    }

    @Override
    public void serialize(Order order, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", order.getId());
        jsonGenerator.writeStringField("date", order.getDate().toString());
        jsonGenerator.writeObjectField("client", order.getClient1());
        jsonGenerator.writeObjectField("item", order.getItem());
        jsonGenerator.writeStringField("description", order.getDescription());
        jsonGenerator.writeEndObject();
    }
}
