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

        /*Temporary solution. Read about ordering by PK...
        Another way(lose lazy loading):
        SQLSelect<Order> select = SQLSelect.query( Order.class,"SELECT * FROM public.Order ORDER BY id DESC");
        List<Order> orderList = context.select(select);

         */


        return orders;
    }

    @Override
    public Order get(int id) {
        ObjectContext context = serverRuntime.newContext();
        Order order = Cayenne.objectForPK(context, Order.class, id);
        Order ordert = SelectById.query(Order.class, id).prefetch(Order.ITEM.joint()).selectFirst(context);
        Cayenne.intPKForObject(order);
        Order order2 = SelectById.query(Order.class, id).selectFirst(context);
        return order2;
    }

    @Override
    public Order save(Order order) {
        ObjectContext context = serverRuntime.newContext();
        //Item item = Cayenne.objectForPK(context, Item.class, order.getTempItemId());
        Item item = SelectById.query(Item.class, order.getTempItemId()).selectOne(context);


        System.out.println(PersistenceState.persistenceStateName(item.getPersistenceState()));
        Client client = Cayenne.objectForPK(context, Client.class, order.getTempClientId());
        order.setItem(item);
        order.setClient1(client);
        LocalDateTime date = LocalDateTime.now();
        order.setDate(date);
        context.registerNewObject(order);
        context.commitChanges();
        return order;
    }

}
