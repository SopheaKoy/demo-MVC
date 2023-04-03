package co.sophea.mvcapp.contronller;

import co.sophea.mvcapp.dao.ProductDaoImp;
import co.sophea.mvcapp.dto.CreateProductDto;
import co.sophea.mvcapp.dto.ProductDto;
import java.util.List;
import java.util.UUID;

public class ProductoController {
    private final ProductDaoImp productDao;

    public ProductoController() {
        productDao = new ProductDaoImp();
    }
    public List<ProductDto> handleProductList (){
        return productDao.select();
    }
    public ProductDto handleCreateNewProduct(CreateProductDto createProductDto){
        return productDao.insert(createProductDto);
    }
    public void handleRemoveProductByUUID(UUID uuid){
        productDao.removeByUUID(uuid);
    }

    public void handleEditProductByUUID(UUID uuid){
        productDao.updateByUUID(uuid);
    }
    public void handleSearchProductByName(String name){
        productDao.searchName(name);
    }
}
