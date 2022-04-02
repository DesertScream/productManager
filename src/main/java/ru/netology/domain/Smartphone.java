package ru.netology.domain;

public class Smartphone extends Product {
    private String name;
    private String manufactured;

    public Smartphone(int id, String name, int price, String name1, String manufactured) {
        super(id, name, price);
        this.name = name1;
        this.manufactured = manufactured;
    }

    public Smartphone(String name, String manufactured) {
        this.name = name;
        this.manufactured = manufactured;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }
}
