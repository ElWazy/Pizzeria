package com.lutrias.pizzeria.context.pizza.application;

import com.lutrias.pizzeria.context.pizza.domain.PizzaRepository;
import com.lutrias.pizzeria.context.pizza.domain.PizzaTypeDTO;

public final class DeletePizza {
    private PizzaRepository repository;

    public DeletePizza(PizzaRepository repository) {
        this.repository = repository;
    }

    public void delete(PizzaTypeDTO pizza) {
        repository.delete(pizza);
    }
}
