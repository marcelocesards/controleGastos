package br.com.controleGastos.controleGastos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.controleGastos.controleGastos.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
