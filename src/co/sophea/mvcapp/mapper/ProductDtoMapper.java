package co.sophea.mvcapp.mapper;

import co.sophea.mvcapp.dto.ProductDto;
import co.sophea.mvcapp.model.Product;

import java.util.function.Function;

public class ProductDtoMapper implements Function<Product , ProductDto> {
    @Override
    public ProductDto apply(Product product) {
        return new ProductDto(
                product.getUui(),
                product.getName(),
                product.getPrice()
        );
    }
}
