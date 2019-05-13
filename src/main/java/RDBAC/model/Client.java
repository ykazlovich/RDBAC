package RDBAC.model;

import RDBAC.model.auto._Client;

public class Client extends _Client {

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return (getObjectId() != null && !getObjectId().isTemporary())
                ? (Integer) getObjectId().getIdSnapshot().get(ID_PK_COLUMN) : null;
    }

    public boolean isNew() {
        return this.getPersistenceState() == 1;

    }

    @Override
    public String toString() {
        Integer i = getId();
        if (i == null) {
            i = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Client ID=")
                .append(this.getId())
                .append(". Name=")
                .append(this.getName())
                .append(". Phone=")
                .append(this.getPhone());
        return sb.toString();
    }

}
