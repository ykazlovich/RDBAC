package RDBAC.web.jackson.client;

import RDBAC.model.Client;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.apache.cayenne.ObjectId;

import java.io.IOException;

public class ClientDeserializer extends StdDeserializer<Client> {

    public ClientDeserializer(){
        super(Client.class);
    }

    @Override
    public Client deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        Client client = new Client();
        JsonNode node = p.getCodec().readTree(p);
        //client.setObjectId(new ObjectId("client", "id", node.get("id").asInt()));
        if(node.has("id")){
            client.setObjectId(new ObjectId("Client", "id", node.get("id").asInt()));
        }
        client.setName(node.get("name").asText());
        client.setPhone(node.get("phone").asText());
        return client;
    }
}
