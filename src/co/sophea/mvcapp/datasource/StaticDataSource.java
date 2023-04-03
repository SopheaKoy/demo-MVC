package co.sophea.mvcapp.datasource;

import co.sophea.mvcapp.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StaticDataSource {
    private List<Product> products;
    //constructor
    public StaticDataSource(){
        products = new ArrayList<>();
        products.add(new Product(UUID.randomUUID(),"Coca",12.0));
        products.add(new Product(UUID.randomUUID(),"String",34.0));
        products.add(new Product(UUID.randomUUID(),"Water",1.0));
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
