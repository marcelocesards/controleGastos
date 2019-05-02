package br.com.controleGastos.controleGastos.controllers;

import javax.jms.JMSException;
import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.controleGastos.controleGastos.jms.consumer.Producer;
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
	
	@Autowired private JmsTemplate jmsTemplate;
	
	@ApiOperation(value = "Faz um novo lançamento", 
			notes = "Faz um novo lançamento de depesa ou provento",
			response = Item.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Lançamento incluído com sucesso"),
	})
	@RequestMapping(method= RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Item create(@RequestBody Item item){
		service.save(item);
		try {
			new Producer().testeJMS(item);
		} catch (NamingException | JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}
}