package RDBAC.model;

import RDBAC.model.auto._Client;
import org.apache.cayenne.Cayenne;
import org.apache.cayenne.ObjectId;

import java.util.Objects;

public class Client extends _Client {

    private static final long serialVersionUID = 1L;

    public Client() {
    }
    public Client(int id, String name, String phone){
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
    }

    public Integer getId() {
        //if  (this.getPersistenceState() == 1 || this.getPersistenceState() == 2) return -1;
        return Cayenne.intPKForObject(this);
    }

    public boolean isNew() {
        return this.getPersistenceState() == 1;
    }

    @Override
    public String toString() {
        return "Client{"+
                "Name=" + this.getName() +
                ". Phone=" + this.getPhone();
        }

    public void setId(int id){
        this.setObjectId(new ObjectId("Client", "id", id));
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.getId(),
                this.getName(),
                this.getPhone());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Client client = (Client) obj;
        return Objects.equals(this.getId(), client.getId()) &&
                Objects.equals(this.getName(), client.getName()) &&
                Objects.equals(this.getPhone(), client.getPhone());
    }
}
