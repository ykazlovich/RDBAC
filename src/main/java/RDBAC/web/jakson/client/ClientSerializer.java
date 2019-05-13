package RDBAC.web.jakson.client;

import RDBAC.model.Client;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Optional;

public class ClientSerializer extends StdSerializer<Client> {


    public ClientSerializer(Class<Client> t) {
        super(t);
    }

    @Override
    public void serialize(Client client, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Integer i = client.getId();
        if(i == null) {
            i = 0;
        }
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", client.getId());
        jsonGenerator.writeStringField("name", client.getName());
        jsonGenerator.writeStringField("phone", client.getPhone());
        jsonGenerator.writeEndObject();
    }
}
