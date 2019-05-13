package RDBAC.repository;

import RDBAC.model.Item;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.query.SelectById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ItemRepositoryImpl implements ItemRepository {

    @Autowired
    private ServerRuntime serverRuntime;

    @Override
    public Item get(int id) {
        ObjectContext context = serverRuntime.newContext();
        Item item = SelectById.query(Item.class, id).selectFirst(context);
        return item;
    }

    @Override
    public List<Item> getAll() {
        ObjectContext context = serverRuntime.newContext();
        return ObjectSelect.query(Item.class).select(context);
    }

    @Override
    public Item save(Item item) {
        ObjectContext context = serverRuntime.newContext();
        context.registerNewObject(item);
        context.commitChanges();
        return item;
    }
}
