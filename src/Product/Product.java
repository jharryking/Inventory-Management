package Product;

import java.awt.image.BufferedImage;

//test
public class Product {
    public ProductDetails details;
    public ProductShippingDetails shippingDetails;
    public final int id;
    private final String sellerName;
    private BufferedImage image;

    public Product(ProductDetails productDetails, ProductShippingDetails productShippingDetails, int id,
                   String sellerName, BufferedImage image){
        this.details = productDetails;
        this.shippingDetails = productShippingDetails;
        this.id = id;
        this.sellerName = sellerName;
        this.image = image;
    }

    public BufferedImage getImage(){
        return image;
    }

    public void printProduct(){
        System.out.println("ID: " + id + " | Name: " + details.getProductName()
                            + " | Quantity: " + details.getQuantity()
                            + " | Price: " + details.getPrice());
    }

    public String getSellerName() {
        return sellerName;
    }
    public ProductDetails getProductDetails(){
        return details;
    }

    public int getID (){
        return id;
    }

    public ProductShippingDetails getShippingDetails() {
        return shippingDetails;
    }
}
