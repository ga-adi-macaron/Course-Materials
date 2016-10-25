package com.example.jeanweatherwax.sqliteandroidindpractice;

/**
 * Created by jeanweatherwax on 6/21/16.
 */
public class Television {

    private int id;
    private String brand;
    private String size;
    private Integer price;


    public Television(int id, String brand, String size, Integer price) {
        this.id = id;
        this.brand = brand;
        this.size = size;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
