package co.sophea.mvcapp.view;

import co.sophea.mvcapp.dto.ProductDto;

import java.util.List;

public class ProductView {

    public static void List(List<ProductDto> productDtoList){
        System.out.println("===================================");
        System.out.println("My ProductList");
        productDtoList.forEach(productDto -> {
            System.out.println("===============================");
            System.out.println("UUID : "+productDto.uuid());
            System.out.println("NAME : "+productDto.name());
            System.out.println("PRICE : "+productDto.price());

        });
    }
    public static void display(ProductDto productDto){
        System.out.println("=================Product==============");
        System.out.println("UUID : "+productDto.uuid());
        System.out.println("NAME : "+productDto.name());
        System.out.println("PRICE : "+productDto.price());
    }
}
