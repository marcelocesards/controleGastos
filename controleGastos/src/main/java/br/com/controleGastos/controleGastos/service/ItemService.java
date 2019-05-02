package br.com.controleGastos.controleGastos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controleGastos.controleGastos.model.Item;
import br.com.controleGastos.controleGastos.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository repository;
	
	public  Iterable<Item> getAll(){
		Iterable<Item> items = repository.findAll();
		return items;
	}
	
	public Item save(Item item) {
		return repository.save(item);
	}
}
