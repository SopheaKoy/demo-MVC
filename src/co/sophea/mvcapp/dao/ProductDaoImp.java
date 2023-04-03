package co.sophea.mvcapp.dao;

import co.sophea.mvcapp.datasource.StaticDataSource;
import co.sophea.mvcapp.dto.CreateProductDto;
import co.sophea.mvcapp.dto.ProductDto;
import co.sophea.mvcapp.exception.ProductNotFoundException;
import co.sophea.mvcapp.mapper.CreateProductMapper;
import co.sophea.mvcapp.mapper.ProductDtoMapper;
import co.sophea.mvcapp.model.Product;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProductDaoImp implements ProductDao{
    private final StaticDataSource staticDataSource ;
    private final CreateProductMapper createProductMapper ;
    private final ProductDtoMapper productDtoMapper;

    public ProductDaoImp() {
        this.staticDataSource = new StaticDataSource();
        this.createProductMapper = new CreateProductMapper();
        this.productDtoMapper = new ProductDtoMapper();
    }

    @Override
    public List<ProductDto> select() {
        return staticDataSource.getProducts()
                .stream()
                .map(productDtoMapper::apply)
                .collect(Collectors.toList());
    }
    @Override
    public ProductDto insert(CreateProductDto createProductDto) {
        Product productForInsert = createProductMapper.apply(createProductDto);
        staticDataSource.getProducts().add(productForInsert);
        return productDtoMapper.apply(productForInsert);
    }

    @Override
    public void removeByUUID(UUID uuid) {
        boolean isNotFound = false;
        for(Product products : staticDataSource.getProducts()){
            if (products.getUui().equals(uuid)){
                isNotFound = true;
                System.out.println("Product Delete Successfully.");
            }
        }
        if (isNotFound){
            System.out.println();
        }

        List<Product> newProduct = staticDataSource.getProducts()
                .stream()
                .filter(product -> product.getUui().equals(uuid))
                .collect(Collectors.toList());
        staticDataSource.setProducts(newProduct);
    }

    @Override
    public void updateByUUID(UUID uuid) {
       List <Product> products = staticDataSource.getProducts();
       List<Product> productsedit = products
               .stream()
               .filter(product -> !products
                       .contains(uuid))
               .collect(Collectors.toList());
    }
    @Override
    public void searchName(String name) {
        List<Product> products = staticDataSource.getProducts();
        boolean productsSearch = products.stream()
                .filter(product -> name.equals(name))
                .allMatch(product -> true);
        if(productsSearch){
            System.out.println("Product Name "+name+" was founded . ");
        }else{
            System.out.println("Product Name "+name+" was not found..!");
        }
    }
}
