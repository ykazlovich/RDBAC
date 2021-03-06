package RDBAC.model.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import RDBAC.model.Order;

/**
 * Class _Client was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Client extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "id";

    public static final Property<String> NAME = Property.create("name", String.class);
    public static final Property<String> PHONE = Property.create("phone", String.class);
    public static final Property<List<Order>> ORDERS = Property.create("orders", List.class);

    public void setName(String name) {
        writeProperty("name", name);
    }
    public String getName() {
        return (String)readProperty("name");
    }

    public void setPhone(String phone) {
        writeProperty("phone", phone);
    }
    public String getPhone() {
        return (String)readProperty("phone");
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
