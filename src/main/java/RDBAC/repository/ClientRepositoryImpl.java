package RDBAC.repository;

import RDBAC.model.Client;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.ObjectId;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.query.SelectById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    private ServerRuntime serverRuntime;

    @Override
    public Client get(int id) {
        ObjectContext context = serverRuntime.newContext();
        Client client = SelectById.query(Client.class, id).selectOne(context);
        return client;
        //return Cayenne.objectForPK(context, Client.class, id);
    }

    @Override
    public List<Client> getAll() {
        ObjectContext context = serverRuntime.newContext();
        return ObjectSelect.query(Client.class).select(context);
    }

    @Override
    public Client save(Client client) {
        ObjectContext context = serverRuntime.newContext();

        if (!client.isNew()){
            Client old = SelectById.query(Client.class, client.getId()).selectFirst(context);

            old.setPhone(client.getPhone());
            old.setName(client.getName());
            context.commitChanges();
            return old;
        } else {
            //System.out.println(client);
            //client.setPersistenceState(1);
            //Client client1 = new Client();
            //client1.setObjectId(new ObjectId("Client", "id", 61));
            //client1.setPhone("dsf");

            context.registerNewObject(client);
            context.commitChanges();
            return client;
        }
    }
}
