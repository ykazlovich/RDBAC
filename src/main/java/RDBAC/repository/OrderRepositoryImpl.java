package RDBAC.repository;

import RDBAC.model.Client;
import RDBAC.model.Item;
import RDBAC.model.Order;
import org.apache.cayenne.Cayenne;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.PersistenceState;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.query.SelectById;
import org.apache.cayenne.query.SelectQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private ServerRuntime serverRuntime;

    @Override
    public List<Order> getAll() {
        ObjectContext context = serverRuntime.newContext();

        List<Order> orders = ObjectSelect.query(Order.class).select(context);

        return orders;
    }

    @Override
    public Order get(int id) {
        ObjectContext context = serverRuntime.newContext();
        Order order = SelectById.query(Order.class, id).selectFirst(context);
        return order;
    }

    @Override
    public Order save(Order order) {
        ObjectContext context = serverRuntime.newContext();
        Item item = Cayenne.objectForPK(context, Item.class, order.getTempItemId());

        Client client = Cayenne.objectForPK(context, Client.class, order.getTempItemId());
        order.setItem(item);
        order.setClient1(client);
        LocalDateTime date = LocalDateTime.now();
        order.setDate(date);
        context.registerNewObject(order);
        context.commitChanges();
        return order;
    }

}
