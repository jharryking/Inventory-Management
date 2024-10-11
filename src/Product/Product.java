package Product;
//test
public class Product {

    private int id;
    private int quantity;
    private double price;
    private String location;
    private String description;
    private String timePurchased; //The time the item was purchased by the retailer
    private String timeSold; //The time the item was sold


    Product(int id, int quantity, double price, String description, String location){
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.location = location;
    }

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
}
