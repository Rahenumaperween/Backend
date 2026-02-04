package com.portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portfolio.dto.ClientDto;
import com.portfolio.portfolio.entity.Client;
import com.portfolio.portfolio.exception.ClientAlreadyExistException;
import com.portfolio.portfolio.exception.ResourceNotFoundException;
import com.portfolio.portfolio.repository.ClientRepository;
import com.portfolio.portfolio.repository.ProjectRepository;
@Service
public class ClientService {
	@Autowired
	private ClientRepository repo;
	@Autowired
	private ProjectRepository projectrepo;
	//GET ALL CLIENT
	public List<Client> getAllClient() {
		return repo.findAll();
	}
	
	//ADD CLIENT
	public Client addClient(ClientDto clientdto) {
		if(repo.existsByName(clientdto.getName())) {
			throw new ClientAlreadyExistException(
	                "Client already exists with name: " + clientdto.getName()
	        );
		}
		Client client=new Client();
		client.setName(clientdto.getName());
		client.setLogo_url(clientdto.getLogoUrl());
		client.setWebsite_url(clientdto.getWebsiteUrl());
		client.setDescription(clientdto.getDescription());
		
		return repo.save(client);
	}
	
	//GET CLIENT BY ID
	public Client getClientById(long id) {
		return repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Client not found with id:"+id)
				);
	}
	
	
	//UPDATE CLIENT
	public Client updateclient(long id,ClientDto updatedto) {
		Client exist=getClientById(id);
		
		exist.setName(updatedto.getName());
		exist.setLogo_url(updatedto.getLogoUrl());
		exist.setWebsite_url(updatedto.getWebsiteUrl());
		exist.setDescription(updatedto.getDescription());
		
		return repo.save(exist);
	}
	
	// DELETE Client
	public void deleteClient(Long id) {

	    Client existing = getClientById(id);
	    if(projectrepo.existByClient(existing)) {
	        throw new RuntimeException(
	            "Cannot delete client. Projects are linked."
	        );
	    }
	    repo.delete(existing);
	}
}
