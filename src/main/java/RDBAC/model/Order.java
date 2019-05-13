package RDBAC.model;

import RDBAC.model.auto._Order;
import org.apache.cayenne.Cayenne;
import org.apache.cayenne.ObjectId;
import org.apache.cayenne.PersistenceState;

public class Order extends _Order {

    private Integer tempItemId;

    private Integer tempClientId;

    public Integer getTempItemId() {
        return tempItemId;
    }

    public void setTempItemId(Integer tempItemId) {
        this.tempItemId = tempItemId;
    }

    public Integer getTempClientId() {
        return tempClientId;
    }

    public void setTempClientId(Integer tempClientId) {
        this.tempClientId = tempClientId;
    }

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
//        return (getObjectId() != null && !getObjectId().isTemporary())
//                ? (Integer) getObjectId().getIdSnapshot().get(ID_PK_COLUMN)
//                : null;

        return Cayenne.intPKForObject(this);

    }

    public void setId(int id){
        this.setObjectId(new ObjectId("Order", "pk", id));
    }


}
