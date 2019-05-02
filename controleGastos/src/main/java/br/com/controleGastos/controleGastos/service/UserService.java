package br.com.controleGastos.controleGastos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controleGastos.controleGastos.model.User;
import br.com.controleGastos.controleGastos.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public  Iterable<User> getAll(){
		Iterable<User> user = repository.findAll();
		return user;
	}
	
	public User save(User user) {
		return repository.save(user);
	}
}
