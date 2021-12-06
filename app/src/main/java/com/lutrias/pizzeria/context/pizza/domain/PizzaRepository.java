package com.lutrias.pizzeria.context.pizza.domain;

import java.util.List;

public interface PizzaRepository {
    public List<PizzaTypeDTO> getAll();

    public void add(PizzaTypeDTO dto);

    public void delete(PizzaTypeDTO dto);
}
