package RDBAC.model;

import RDBAC.model.auto._Item;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import org.apache.cayenne.Cayenne;
import org.apache.cayenne.ObjectId;
import org.apache.cayenne.PersistenceState;
import org.springframework.validation.ObjectError;

import java.util.Objects;

public class Item extends _Item {

    private static final long serialVersionUID = 1L;

    public int getId() {
        return Cayenne.intPKForObject(this);
        //if (this.getPersistenceState() == 1 || this.getPersistenceState() == 2) return -1;

    }

    public boolean isNew() {
        return this.getPersistenceState() == 1;
    }

    public Item(int id, String name, String serialno) {
        this.setObjectId(new ObjectId("Item", "id", id));
        super.setIname(name);
        super.setSerialno(serialno);
    }

    public Item() {
    }

    public void setId(int id) {
        this.setObjectId(new ObjectId("Item", "id", id));
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID=" + this.getId() +
                ". Model=" + this.getIname() +
                ". SerialNumber=" + this.getSerialno() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Item item = (Item) obj;
        return Objects.equals(item.getId(), this.getId())
                && Objects.equals(item.getIname(), this.getIname())
                && Objects.equals(item.getSerialno(), this.getSerialno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.getId(),
                this.getIname(),
                this.getSerialno());
    }
}
