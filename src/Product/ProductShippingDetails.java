package Product;

public class ProductShippingDetails {
    String address;
    int zip;
    String country;

    public ProductShippingDetails(String address, int zip, String country){
        this.address = address;
        this.zip = zip;
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public int getZip() {
        return zip;
    }
}
