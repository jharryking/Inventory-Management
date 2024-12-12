import Database.DB;
import Product.*;
import Users.SellerAccount;
import Users.UserAccount;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;


public class Main {
    public static void main(String[] args){
        SellerAccount sellerAccount  = new SellerAccount("harryseller", "1245");
        ProductDetails productDetails= new ProductDetails(10, BigDecimal.TEN, true, "description", "imagetest3", "C:\\Users\\jharr\\OneDrive\\Desktop\\DBImages\\apple.jpg");
        ProductShippingDetails productShippingDetails = new ProductShippingDetails("address", 11111, "country");
        sellerAccount.createProduct(productDetails, productShippingDetails);
        sellerAccount.getUserInfo().print();
        sellerAccount.updateProductManager("harryseller");
        //userAccount.getProductManager().printProductMap();
        //userAccount.purchaseProduct(userAccount.getProductManager().getProduct(7),2);
        //userAccount.getProductManager().printProductMap();


        /*
                ProductManager productManager= new ProductManager();
        DB db = new DB();
        SellerAccount account = new SellerAccount(db, productManager);
        System.out.println(account.login("harryseller", "1245"));

        ProductDetails productDetails= new ProductDetails(10, BigDecimal.TEN, true, "description", "product20");
        ProductShippingDetails productShippingDetails = new ProductShippingDetails("address", 11111, "country");
        db.modifyProductEntry(7, productDetails, productShippingDetails, productManager);
        //account.purchaseProduct(7, 6);

         */
    }

}
