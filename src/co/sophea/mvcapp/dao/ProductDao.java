package co.sophea.mvcapp.dao;

import co.sophea.mvcapp.dto.CreateProductDto;
import co.sophea.mvcapp.dto.ProductDto;
import co.sophea.mvcapp.exception.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductDao {
    //abstract method
    List<ProductDto> select();
    ProductDto insert(CreateProductDto createProductDto);
    void removeByUUID(UUID uuid) throws ProductNotFoundException;
    void updateByUUID(UUID uuid) throws ProductNotFoundException;

    void searchName(String name);
}
