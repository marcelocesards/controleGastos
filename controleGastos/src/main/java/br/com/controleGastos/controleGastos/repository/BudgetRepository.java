package br.com.controleGastos.controleGastos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.controleGastos.controleGastos.model.Budget;

public interface BudgetRepository extends CrudRepository<Budget, Long> {
}
