package RDBAC.model;

import RDBAC.model.auto._Order;
import org.apache.cayenne.Cayenne;
import org.apache.cayenne.ObjectId;

import java.util.Objects;

public class Order extends _Order {

    private static final long serialVersionUID = 1L;

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

    public Integer getId() {
        //if (this.getPersistenceState() == 1 || this.getPersistenceState() == 2) return -1;
        return Cayenne.intPKForObject(this);
    }

    public void setId(int id) {
        this.setObjectId(new ObjectId("Order", "id", id));
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID" + this.getId() +
                "Description=" + this.getDescription() +
                ", Item=" + this.getItem() +
                ", Client=" + this.getClient1() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.getId(),
                this.getClient1(),
                this.getItem(),
                this.getDescription());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return Objects.equals(this.getId(), order.getId()) &&
                Objects.equals(this.getDescription(), order.getDescription()) &&
                Objects.equals(this.getClient1(), order.getClient1()) &&
                Objects.equals(this.getItem(), order.getItem());
    }
}
