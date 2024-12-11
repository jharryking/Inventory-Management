package Users;

import Database.DB;
import Product.ProductDetails;
import Product.ProductManager;
import Product.ProductShippingDetails;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SellerAccount extends UserAccount{

    public SellerAccount(String username, String password){
        super(username, password);
    }

    public boolean modifyProduct(int productID, ProductDetails newProductDetails,
                                 ProductShippingDetails newShippingDetails){
        if(!db.modifyProductEntry(productID, newProductDetails, newShippingDetails)){
            return false;
        }
        updateProductManager(userInfo.getUsername());
        return true;
    }

    public boolean createProduct(ProductDetails productDetails, ProductShippingDetails productShippingDetails){
            if (!db.addProductEntry(productDetails, productShippingDetails)){return false;}
            updateProductManager(userInfo.getUsername());
            return true;
    }


}
