package challenge.designpatterns.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import challenge.designpatterns.model.Address;


// https://viacep.com.br"
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

	@GetMapping("/{zipCode}/json/")
	Address searchZipCode(@PathVariable("zipCode") String zipCode);
}
