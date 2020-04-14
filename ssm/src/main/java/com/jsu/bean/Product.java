package com.jsu.bean;

import java.io.Serializable;

/**
 * 产品类  一个产品对应一个产品类
 * id name price
 * discounts(优惠价格)
 * star 星级
 * description 描述
 * amount 已经出售多少件
 */
public class Product implements Serializable {
    private int id;
    private String name;
    private double price;
    private double discounts;
    private int star;
    private String description;
    private int amount;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discounts=" + discounts +
                ", star=" + star +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
