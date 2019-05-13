package RDBAC.service;

import RDBAC.model.Client;

import java.util.List;

public interface ClientService {
    Client get(int id);
    List<Client> getAll();
    Client save(Client client);
}
