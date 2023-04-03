package co.sophea.mvcapp.mapper;

import co.sophea.mvcapp.dto.CreateProductDto;
import co.sophea.mvcapp.model.Product;

import java.util.UUID;
import java.util.function.Function;

public class CreateProductMapper implements Function<CreateProductDto , Product> {
    @Override
    public Product apply(CreateProductDto createProductDto) {
        return new Product(
                UUID.randomUUID(),
                createProductDto.name(),
                createProductDto.price()
        );
    }
}
