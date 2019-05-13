package RDBAC.model.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import RDBAC.model.Order;

/**
 * Class _Item was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Item extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "id";

    public static final Property<String> INAME = Property.create("iname", String.class);
    public static final Property<String> SERIALNO = Property.create("serialno", String.class);
    public static final Property<List<Order>> ORDERS = Property.create("orders", List.class);

    public void setIname(String iname) {
        writeProperty("iname", iname);
    }
    public String getIname() {
        return (String)readProperty("iname");
    }

    public void setSerialno(String serialno) {
        writeProperty("serialno", serialno);
    }
    public String getSerialno() {
        return (String)readProperty("serialno");
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
