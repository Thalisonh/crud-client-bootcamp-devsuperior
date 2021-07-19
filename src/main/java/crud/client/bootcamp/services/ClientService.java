package crud.client.bootcamp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import crud.client.bootcamp.entities.Client;
import crud.client.bootcamp.entities.dto.ClientDTO;
import crud.client.bootcamp.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public Page<ClientDTO> getByPage(PageRequest pageRequest) {
		Page<Client> list = clientRepository.findAll(pageRequest);
		
		return list.map(x -> new ClientDTO(x));
	}
}
