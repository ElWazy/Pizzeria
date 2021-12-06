package com.lutrias.pizzeria.context.pizza.application;

import com.lutrias.pizzeria.context.pizza.domain.PizzaIngredient;
import com.lutrias.pizzeria.context.pizza.domain.PizzaTypeDTO;

public final class CalcTotalPrice {
    private PizzaTypeDTO type;
    private PizzaIngredient ingredient;

    public CalcTotalPrice(PizzaTypeDTO type, PizzaIngredient ingredient) {
        this.type = type;
        this.ingredient = ingredient;
    }

    public int process() {
        return type.getPrice() + ingredient.value();
    }
}
