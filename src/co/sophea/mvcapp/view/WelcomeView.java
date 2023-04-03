package co.sophea.mvcapp.view;

import co.sophea.mvcapp.contronller.ProductoController;
import co.sophea.mvcapp.dto.CreateProductDto;
import co.sophea.mvcapp.dto.ProductDto;
import co.sophea.mvcapp.util.InputView;

import java.util.UUID;

public class WelcomeView {
    public void showProductMenu(){
        System.out.println("======================================");
        System.out.println("Welcome to My Application");
        System.out.println("======================================");
        System.out.println("1-> Create new Product");
        System.out.println("2-> List all Product ");
        System.out.println("3-> Remove product by UUID ");
        System.out.println("4-> Update product by UUID ");
        System.out.println("5-> Search product by Name ");
        System.out.println("0-> Exit Application");
        System.out.println("========================================");
    }
    public void showMessage(String message){
        System.out.println("------------------------------------------");
        System.out.println("-> "+message);
    }
    public void render(){
        ProductoController controller = new ProductoController();
        while (true){
            this.showProductMenu();

            int option = InputView.getInteger("Choose one Option :");
            switch (option){
                case 0->{
                    System.out.println("Thank you for using our program");
                    System.exit(0);
                }
                case 1->{
                    this.showMessage("Create New Product");
                    String name = InputView.getText("Enter Name : ");
                    Double price =InputView.getFloatPoint("Enter Price : ");
                    CreateProductDto createProductDto = new CreateProductDto(name,price);
                    ProductDto productDto = controller.handleCreateNewProduct(createProductDto);
                    this.showMessage("Product has been created Successfully.");
                    ProductView.display(productDto);
                }
                case 2->{
                    this.showMessage("Product have been found Successfully");
                    ProductView.List(controller.handleProductList());
                }
                case 3->{
                    UUID uuid = UUID.fromString((InputView.getText("Enter UUID : ")));
                    controller.handleRemoveProductByUUID(uuid);
                    this.showMessage("Remove Product Successfully.");
                }
                case 4->{
                    UUID uuid = UUID.fromString((InputView.getText("Enter UUID to Edit  : ")));
                    String name = InputView.getText("Enter Name : ");
                    Double price =InputView.getFloatPoint("Enter Price : ");
                    CreateProductDto createProductDto = new CreateProductDto(name,price);
                    controller.handleEditProductByUUID(uuid);
                    ProductDto productDto = controller.handleCreateNewProduct(createProductDto);
                    this.showMessage("Product has been Update Successfully.");
                    ProductView.display(productDto);
                }
                case 5->{
                    String name = InputView.getText("Enter Name : ");
                    controller.handleSearchProductByName(name);
                }
                default -> System.out.println("Invalid Option....!");
            }
            InputView.pressEnterToContinue();
        }
    }
}
