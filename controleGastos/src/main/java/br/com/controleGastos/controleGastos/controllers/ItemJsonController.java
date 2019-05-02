package br.com.controleGastos.controleGastos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.controleGastos.controleGastos.model.Item;
import br.com.controleGastos.controleGastos.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/item")
public class ItemJsonController {
	@Autowired
	private ItemService service;
	
	@ApiOperation(value = "Faz um novo lançamento", 
			notes = "Faz um novo lançamento de depesa ou provento",
			response = Item.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Lançamento incluído com sucesso"),
	})
	@RequestMapping(method= RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Item create(@RequestBody Item item){
		service.save(item);
		return item;
	}
}