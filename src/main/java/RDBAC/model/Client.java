package RDBAC.model;

import RDBAC.model.auto._Client;
import org.apache.cayenne.Cayenne;

public class Client extends _Client {

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return Cayenne.intPKForObject(this);
    }

    public boolean isNew() {
        return this.getPersistenceState() == 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(". Name=")
                .append(this.getName())
                .append(". Phone=")
                .append(this.getPhone());
        return sb.toString();
    }

}
