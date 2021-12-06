package com.lutrias.pizzeria.context.pizza.domain;

public final class PizzaIngredient {
    private String id;
    private String name;
    private int price;

    public PizzaIngredient(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int value() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PizzaIngredient)) return false;

        PizzaIngredient that = (PizzaIngredient) o;

        if (price != that.price) return false;
        if (!id.equals(that.id)) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + price;
        return result;
    }
}
