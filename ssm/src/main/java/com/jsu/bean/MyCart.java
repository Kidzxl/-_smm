package com.jsu.bean;

public class MyCart {
    private int id;
    private String name;
    private double price;
    private double discounts;
    private int star;
    private String description;
    private int sell;
    private int inventory;
    private int num;

    @Override
    public String toString() {
        return "MyCart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discounts=" + discounts +
                ", star=" + star +
                ", description='" + description + '\'' +
                ", sell=" + sell +
                ", inventory=" + inventory +
                ", num=" + num +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscounts() {
        return discounts;
    }

    public void setDiscounts(double discounts) {
        this.discounts = discounts;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
