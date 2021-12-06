package com.lutrias.pizzeria.context.pizza.domain;

public class PizzaTypeDTO {
    private String id;
    private String name;
    private int price;
    private String location;

    public PizzaTypeDTO(String id, String name, int price, String location) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return name;
    }
}
