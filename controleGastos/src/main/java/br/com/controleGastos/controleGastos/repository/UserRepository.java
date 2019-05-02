package br.com.controleGastos.controleGastos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.controleGastos.controleGastos.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
