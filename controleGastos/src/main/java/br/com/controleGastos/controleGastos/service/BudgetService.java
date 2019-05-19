package br.com.controleGastos.controleGastos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controleGastos.controleGastos.model.Budget;
import br.com.controleGastos.controleGastos.repository.BudgetRepository;

@Service
public class BudgetService {
	@Autowired
	private BudgetRepository repository;

	public Iterable<Budget> getAll() {
		Iterable<Budget> budgets = repository.findAll();
		return budgets;
	}
	
	public Optional<Budget> getById(Long id) {
		Optional<Budget> findById = repository.findById(id);
		return findById;
	}

	public Budget save(Budget budget) {
		return repository.save(budget);
	}
}
