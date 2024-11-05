package Finances;

import Product.Product;
import Product.ProductManager;

import java.util.Enumeration;
import java.util.HashMap;

public abstract class BaseSellerFinances extends BaseFinances {
    protected ProductManager productManager;


    BaseSellerFinances(ProductManager productManager) {
        super();
        init(productManager);
    }

    BaseSellerFinances(ProductManager productManager, double funds) {
        super(funds);
        init(productManager);
    }

    private void init(ProductManager productManager) {
        this.productManager = productManager;
    }

    public double getTotalProductCost(){
        double totalCost = 0;

        HashMap<Integer, Product> productMap = productManager.getProductMap();
        for (Product product : productMap.values()){
            totalCost += product.getPrice() * product.getQuantity();
        }

        return totalCost;
    }


    public void generateProductReport() {
        System.out.println("ID: " + super.getID());
        System.out.println("Total Funds: " + super.getFunds());
        System.out.println("Total cost of products in inventory: " + getTotalProductCost());
    }

}
