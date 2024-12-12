package Users;

import Database.DB;
import Product.ProductManager;
import Product.Product;

import java.math.BigDecimal;
import java.util.HashMap;

public class UserAccount {
    protected DB db;
    protected ProductManager productManager;
    protected UserInfo userInfo;

    public UserAccount(String username, String password){
        db = new DB(username, password);
        userInfo = db.getUserInfo();
        productManager = new ProductManager();
    }

    public DB getDb() {
        return db;
    }

    public void print(){
        //userInfo.print();
    }


    public UserInfo getUserInfo() {
        return userInfo;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public boolean addFunds(BigDecimal funds){
        boolean result = db.addFunds(funds);
        if (!result){return false;}
        userInfo = db.getUserInfo();
        return true;
    }

    public boolean updateProductManager(String sellerName){
        HashMap<Integer, Product> productHashMap = db.getSellerProductsHashMap(sellerName);
        if (productHashMap == null) {return false;}
        productManager.changeProductMap(productHashMap);
        return true;
    }

    public boolean purchaseProduct(Product product, int purchaseQuantity){
        boolean result = db.invokePurchase(product.getID(), purchaseQuantity);
        if (!result){return false;}
        userInfo = db.getUserInfo();
        updateProductManager(product.getSellerName());
        return true;
    }
}

