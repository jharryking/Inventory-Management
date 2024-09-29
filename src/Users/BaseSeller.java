package Users;

import Product.ProductManager;
import Utilities.Utilities;

public abstract class BaseSeller {
    protected ProductManager productManager = new ProductManager();
    private String sellerName;

    public boolean sellProduct(int productID){
        return true;
    }


    public boolean promptCreateProduct() {
        int id;
        int quantity;
        double price;
        String description;
        String location;

        System.out.print("Enter the ID of the product: ");
        id = Utilities.input.nextInt();
        System.out.print("Enter the quantity of the product: ");
        quantity = Utilities.input.nextInt();
        System.out.print("Enter the price of the product: ");
        price = Utilities.input.nextDouble();
        System.out.print("Enter the description of the product: ");
        description = Utilities.input.nextLine();
        System.out.print("Enter the location of the product: ");
        location = Utilities.input.nextLine();
        return productManager.createProduct(id, quantity, price, description, location);
    }


}
