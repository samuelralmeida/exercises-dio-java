package challenge.designpatterns.service;

import challenge.designpatterns.model.Client;

public interface ClientService {

	Iterable<Client> fetchAll();

	Client fetchById(Long id);

	void insert(Client client);

	void update(Long id, Client client);

	void delete(Long id);

}
