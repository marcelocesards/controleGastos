package br.com.controleGastos.controleGastos.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.controleGastos.controleGastos.model.Budget;
import br.com.controleGastos.controleGastos.service.BudgetService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/budget")
public class BudgetController {
	
	@Autowired
	BudgetService service;
	
	@ApiOperation(value = "Lista de orçamentos", 
			notes = "Lista todos os orçamentos" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Orçamentos Listados com sucesso"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar este recurso"),
		    @ApiResponse(code = 403, message = "O acessar a este recurso foi negado"),
		    @ApiResponse(code = 404, message = "O recurso não foi encontrado") })
	@GetMapping
	public String getAll(Model model){
		Iterable<Budget> budgets = service.getAll();
		model.addAttribute("budgets", budgets);
		return "budgetList";
	}
	
	@ApiOperation(value = "Busca um orçamento por Id", 
			notes = "Busca um orçamento por ID e lista todos os items" )
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Orçamento encontrado com sucesso"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar este recurso"),
		    @ApiResponse(code = 403, message = "O acessar a este recurso foi negado"),
		    @ApiResponse(code = 404, message = "O recurso não foi encontrado") })
	@GetMapping("/{id}")
	public String getById(Model model, @PathVariable("id") long id){
		Optional<Budget> budget = service.getById(id);
		budget.orElseThrow(() -> new RuntimeException("Orçamento não encontrado"));
		budget.ifPresent(b -> model.addAttribute("items", b.getItems()));		
		return "budget";
	}
}

