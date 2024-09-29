package Finances;

import Product.ProductManager;

public class RetailerFinances extends BaseSellerFinances{
    public RetailerFinances(ProductManager productManager) {
        super(productManager);
    }
    public RetailerFinances(ProductManager productManager, double funds){
        super(productManager, funds);
    }

}
