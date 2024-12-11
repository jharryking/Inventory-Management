package Product;

import java.math.BigDecimal;
import java.util.*;

public class ProductManager {

    private HashMap<Integer, Product> productMap = new HashMap<>();

    public HashMap<Integer, Product> getProductMap(){
        return productMap;
    }

    public Product getProduct(int id){
        Product product = productMap.get(id);
        if (product == null){
            System.out.println("Did not find product with that ID");
            return null;
        }
        return product;
    }

    public void addProduct(Product product){
        int id = product.getID();
        if (productMap.get(id) != null){return;}
        productMap.put(id, product);
    }

    public void changeProductMap(HashMap<Integer, Product> productMap){
        this.productMap = productMap;
    }

    public void clear(){
        productMap.clear();
    }

    public void printProductMap(){
        System.out.println("Product Map: ");
        for (Map.Entry<Integer,Product> entry : productMap.entrySet()){
            Product product = entry.getValue();
            product.printProduct();
        }
    }

    public ArrayList<String> getProductNames(){
        ArrayList<String> productNames = null;
        return productNames;
    }
}
/*
    public boolean removeProduct(int id){
        if (productMap.get(id) == null){
            return false;
        }
        productMap.remove(id);
        return true;
    }

    public boolean createProduct(int id, int quantity, double price, String description, String location){
        if (productMap.get(id) != null) {
            System.out.println("There is already a product with the same ID that has been created");
            return false;
        }

        Product product = new Product(id, quantity, price, description, location);
        productMap.put(id, product);
        System.out.println("Product created Successfully!");
        return true;
    }

    public boolean buyProduct(int id, int buyQuantity){
        Product product = productMap.get(id);
        if (product == null) {
            System.out.println("Could not find product.");
            return false;
        }

        if (buyQuantity <= 0 ){
            System.out.println("Enter a value greater than zero to buy.");
            return false;
        }

        product.setQuantity(buyQuantity + product.getQuantity());
        return true;
    }

    public boolean sellProduct(int id, int sellQuantity) {
        Product product = productMap.get(id);
        if (product == null) {
            System.out.println("Could not find product.");
            return false;
        }

        int newQuantity = product.getQuantity() - sellQuantity;
        if (newQuantity < 0 ){
            System.out.println("The quantity entered is greater than what's in stock.");
            return false;
        }

        product.setQuantity(newQuantity);
        System.out.println(sellQuantity + " units of " + id + " sold.");
        return true;
    }
 */
