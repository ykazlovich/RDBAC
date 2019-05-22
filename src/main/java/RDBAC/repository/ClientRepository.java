package RDBAC.repository;

import RDBAC.model.Client;

import java.util.List;

public interface ClientRepository {
    Client get(int id);
    List<Client> getAll();
    Client save(Client client);
    List<Client> findByNameAndPhone(String search);
}
