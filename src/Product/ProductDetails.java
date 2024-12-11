package Product;

import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;

public class ProductDetails {
    private int quantity;
    private BigDecimal price;
    private boolean available;
    private String description;
    private String productName;
    private String imagePath;

    public ProductDetails(int quantity, BigDecimal price, boolean available,
                   String description, String name, String imagePath){
        this.quantity = quantity;
        this.price = price;
        this.available = available;
        this.description = description;
        this.productName = name;
        this.imagePath = imagePath;
    }

    public String getImagePath(){
        return imagePath;
    }

    public int getQuantity (){
        return quantity;
    }

    public BigDecimal getPrice (){
        return price;
    }

    public boolean getAvailable(){
        return available;
    }

    public String getDescription(){
        return description;
    }

    public String getProductName (){
        return productName;
    }

}
    /*
        public void changeProductDescription(String newDescription){
        description = newDescription;
    }


    public void displayProduct(){
        //Displays all variables
        System.out.println("");
    }

    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }

    public double getPrice(){
        return price;
    }


    public boolean checkAvailability(int id){
        return quantity > 0;
    }


    public int getQuantity(){
        return quantity;
    }
     */

