package RDBAC.model;

import RDBAC.model.auto._Item;
import org.apache.cayenne.Cayenne;

public class Item extends _Item {

    private static final long serialVersionUID = 1L;

    public int getId() {
        return (getObjectId() != null && !getObjectId().isTemporary())
                ? (Integer) getObjectId().getIdSnapshot().get(ID_PK_COLUMN) : 0;
    }
    public boolean isNew(){
        return this.getPersistenceState() == 1;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item=").append(Cayenne.intPKForObject(this)).append(". Model=").append(this.getIname()).append(". SerialNumber=").append(this.getSerialno());
        return sb.toString();
    }

}
