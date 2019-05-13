package RDBAC.service;

import RDBAC.model.Client;
import RDBAC.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public Client get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = repository.getAll();
        clients.sort((o1, o2) -> o1.getId() < o2.getId() ? -1 : 0);
        return clients;
    }

    @Override
    public Client save(Client client) {
        return repository.save(client);
    }
}
