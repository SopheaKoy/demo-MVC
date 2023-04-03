package co.sophea.mvcapp.model;

import java.util.UUID;

public class Product {
    // field product
    private UUID uuid;
    private String name;
    private Double price;


    // constructor
    public Product(UUID uuid, String name, Double price) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
    }
    public Product(){}
    //setter and getter

    public UUID getUui() {
        return uuid;
    }

    public void setUui(UUID uui) {
        this.uuid = uui;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
