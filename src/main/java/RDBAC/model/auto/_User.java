package RDBAC.model.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import RDBAC.model.Order;

/**
 * Class _User was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _User extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "id";

    public static final Property<String> PASSWORD = Property.create("password", String.class);
    public static final Property<String> UNAME = Property.create("uname", String.class);
    public static final Property<List<Order>> ORDERS = Property.create("orders", List.class);

    public void setPassword(String password) {
        writeProperty("password", password);
    }
    public String getPassword() {
        return (String)readProperty("password");
    }

    public void setUname(String uname) {
        writeProperty("uname", uname);
    }
    public String getUname() {
        return (String)readProperty("uname");
    }

    public void addToOrders(Order obj) {
        addToManyTarget("orders", obj, true);
    }
    public void removeFromOrders(Order obj) {
        removeToManyTarget("orders", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<Order> getOrders() {
        return (List<Order>)readProperty("orders");
    }


}
