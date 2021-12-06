package com.lutrias.pizzeria.context.pizza.domain;

public final class PizzaType {
    private String id;
    private String name;
    private int price;

    public PizzaType(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int calcPriceWithExtra(int extraPrice) {
        return price + extraPrice;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PizzaType)) return false;

        PizzaType pizzaType = (PizzaType) o;

        if (price != pizzaType.price) return false;
        if (!id.equals(pizzaType.id)) return false;
        return name.equals(pizzaType.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + price;
        return result;
    }
}
