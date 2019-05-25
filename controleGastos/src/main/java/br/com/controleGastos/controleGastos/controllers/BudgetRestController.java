package br.com.controleGastos.controleGastos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controleGastos.controleGastos.model.Budget;
import br.com.controleGastos.controleGastos.service.BudgetService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/budget")
public class BudgetRestController {	
	@Autowired
	private BudgetService service;

	@ApiOperation(value = "Cria um novo Orçamento", 
			notes = "Cria um novo orçamento",
			response = Budget.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Orçamento incluído com sucesso"),
	})
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Budget budget){	
		service.save(budget);
		return new ResponseEntity<Budget>(budget, HttpStatus.CREATED);
	}
}