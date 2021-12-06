package com.lutrias.pizzeria.context.pizza.infrastructure;

import com.lutrias.pizzeria.context.pizza.domain.PizzaRepository;
import com.lutrias.pizzeria.context.pizza.domain.PizzaTypeDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InMemoryPizzaRepository implements PizzaRepository, Serializable {
    private static List<PizzaTypeDTO> pizzas = new ArrayList<>();

    @Override
    public List<PizzaTypeDTO> getAll() {
        return pizzas;
    }

    @Override
    public void add(PizzaTypeDTO dto) {
        pizzas.add(dto);
    }

    @Override
    public void delete(PizzaTypeDTO dto) {
        pizzas.remove(dto);
    }
}
