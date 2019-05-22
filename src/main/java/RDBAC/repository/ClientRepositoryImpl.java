package RDBAC.repository;

import RDBAC.model.Client;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.ObjectId;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.query.SelectById;
import org.apache.cayenne.query.SortOrder;
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
    public List<Client> findByNameAndPhone(String search) {
        ObjectContext context = serverRuntime.newContext();
        return ObjectSelect
                .query(Client.class)
                .where(Client.NAME.upper().contains(search.toUpperCase()))
                .or(Client.PHONE.contains(search))
                .select(context);
    }

    @Override
    public List<Client> getAll() {
        ObjectContext context = serverRuntime.newContext();
        return ObjectSelect.query(Client.class).select(context);
    }

    @Override
    public Client save(Client client) {
        ObjectContext context = serverRuntime.newContext();

        if (!client.isNew()) {
            Client old = SelectById.query(Client.class, client.getId()).selectFirst(context);

            old.setPhone(client.getPhone());
            old.setName(client.getName());
            context.commitChanges();
            return old;
        } else {
            context.registerNewObject(client);
            context.commitChanges();
            return client;
        }
    }
}
