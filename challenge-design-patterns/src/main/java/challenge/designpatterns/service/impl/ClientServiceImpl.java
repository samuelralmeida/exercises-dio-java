package challenge.designpatterns.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import challenge.designpatterns.model.Address;
import challenge.designpatterns.model.AddressRepository;
import challenge.designpatterns.model.Client;
import challenge.designpatterns.model.ClienteRepository;
import challenge.designpatterns.service.ClientService;
import challenge.designpatterns.service.ViaCepService;

@Service
public class ClientServiceImpl implements ClientService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClienteRepository clienteRepository;
	
    @Autowired
	private AddressRepository addressRepository;
	
    @Autowired
	private ViaCepService viaCepService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Client> fetchAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Client fetchById(Long id) {
		Optional<Client> client = clienteRepository.findById(id);
		return client.get();
	}

	@Override
	public void insert(Client client) {
		saveClientWithZipCode(client);
	}

	@Override
	public void update(Long id, Client client) {
		Optional<Client> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			saveClientWithZipCode(client);
		}
	}

	@Override
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

	private void saveClientWithZipCode(Client client) {
		String zipCode = client.getAddress().getZipCode();

		Address address = addressRepository.findById(zipCode).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Address newAddress = viaCepService.searchZipCode(zipCode);
			addressRepository.save(newAddress);
			return newAddress;
		});

		client.setAddress(address);
		
		clienteRepository.save(client);
	}
}
