package com.lutrias.pizzeria.context.pizza.application;

import com.lutrias.pizzeria.context.pizza.domain.PizzaRepository;
import com.lutrias.pizzeria.context.pizza.domain.PizzaTypeDTO;

public final class AddPizza {
    private PizzaRepository repository;

    public AddPizza(PizzaRepository repository) {
        this.repository = repository;
    }

    public void add(PizzaTypeDTO pizza) throws Exception {
        if (pizza.getName().isEmpty()) {
            throw new Exception("Nombre Vacio");
        }

        repository.add(pizza);
    }
}
