package br.com.controleGastos.controleGastos.controllers;

import javax.jms.JMSException;
import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.controleGastos.controleGastos.jms.consumer.Consumer;
import br.com.controleGastos.controleGastos.model.Item;
import br.com.controleGastos.controleGastos.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService service;
	
	@ApiOperation(value = "Lista de lançamentos", 
			notes = "Lista os lançamentos de todas as depesas e proventos" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Lançamentos Listados com sucesso"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar este recurso"),
		    @ApiResponse(code = 403, message = "O acessar a este recurso foi negado"),
		    @ApiResponse(code = 404, message = "O recurso não foi encontrado") })
	@RequestMapping(method= RequestMethod.GET)
	public String getAll(Model model){
		Iterable<Item> items = service.getAll();
		model.addAttribute("items", items);
		return "itemList";
	}
}

