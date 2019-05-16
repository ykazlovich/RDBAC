package RDBAC.model;

import RDBAC.model.auto._Item;
import org.apache.cayenne.Cayenne;
import org.apache.cayenne.ObjectId;

public class Item extends _Item {

    private static final long serialVersionUID = 1L;

    public int getId() {
        return Cayenne.intPKForObject(this);
    }
    public boolean isNew(){
        return this.getPersistenceState() == 1;
    }

    public Item(int id, String name, String serialno){
        this.setObjectId(new ObjectId("Item", "pk", id));
        super.setIname(name);
        super.setSerialno(serialno);
    }

    public Item() {
    }

    public void setId(int id){
        this.setObjectId(new ObjectId("Item", "pk", id));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item ").append("model=").append(this.getIname()).append(". SerialNumber=").append(this.getSerialno());
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        Item item = (Item) obj;
        if(item.getId() != this.getId()) return false;
        if (!item.getIname().equals(this.getIname())) return false;
        if (!item.getSerialno().equals(this.getSerialno())) return false;
        return true;
    }
}
