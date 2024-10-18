package challenge.designpatterns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.designpatterns.model.Client;
import challenge.designpatterns.service.ClientService;


@RestController
@RequestMapping("clients")
public class ClientRestController {

	@Autowired
	private ClientService clienteService;

	@GetMapping
	public ResponseEntity<Iterable<Client>> fetchAll() {
		return ResponseEntity.ok(clienteService.fetchAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> fetchById(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.fetchById(id));
	}

	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client client) {
		clienteService.insert(client);
		return ResponseEntity.ok(client);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
		clienteService.update(id, client);
		return ResponseEntity.ok(client);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clienteService.delete(id);
		return ResponseEntity.ok().build();
	}
}
