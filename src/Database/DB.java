package Database;


import Product.*;
import Users.UserInfo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class DB {
    private final static String DB_USER = "guest";
    private final static String DB_PW = "";
    private String username;
    private String password;


    public static void main(String[] args){
        //createAccount("harryseller", "1245", true);
        //refreshProductManager(new ProductManager(), "harryseller");
        //updateUserDetails();
        //purchaseProduct(5, 10);
        //createProduct (10, true, 30.00, "",
        //        "address",15413, "US", "product1");

        //getCustomerProducts();

    }

    public DB (String username, String password) {
        if (verifyCredentials(username, password) == LoginDetails.UNSUCCESSFUL){
            throw new RuntimeException("invalid credentials");
        }
        this.username = username;
        this.password = password;
    }

    //updates db based on id and quantity
    public boolean invokePurchase(int productID, int purchaseQuantity){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info",
                    DB_USER, DB_PW);
            String q = "CALL purchase_product(?,?,?,?,?)";
            CallableStatement cs = connection.prepareCall(q);
            cs.setString(1,username);
            cs.setString(2, password);
            cs.setInt(3, productID);
            cs.setInt(4, purchaseQuantity);
            cs.registerOutParameter(5, Types.BOOLEAN);
            cs.execute();
            boolean result = cs.getBoolean(5);
            System.out.println("Result: " + result);
            return result;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean createAccountEntry (String username, String password, boolean seller){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info",
                    DB_USER, DB_PW);
            String q = "CALL create_account(?,?,?,?)";
            CallableStatement cs = connection.prepareCall(q);
            cs.setString(1,username);
            cs.setString(2, password);
            cs.setBoolean(3, seller);
            cs.registerOutParameter(4, Types.BOOLEAN);
            cs.execute();
            boolean result = cs.getBoolean(4);
            System.out.println("Result: " + result);
            return result;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean addProductEntry(ProductDetails productDetails, ProductShippingDetails shippingDetails){
        try{
            File imageFile = new File(productDetails.getImagePath());
            FileInputStream fis = new FileInputStream(imageFile);

            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info",
                    DB_USER, DB_PW);
            String q = "CALL create_product(?,?,?,?,?,?,?,?,?,?,?,?)";
            CallableStatement cs = connection.prepareCall(q);
            cs.setString(1,username);
            cs.setString(2, password);
            cs.setInt(3, productDetails.getQuantity());
            cs.setBoolean(4, productDetails.getAvailable());
            cs.setBigDecimal(5, productDetails.getPrice());
            cs.setString(6, productDetails.getDescription());
            cs.setString(7,shippingDetails.getAddress());
            cs.setInt(8, shippingDetails.getZip());
            cs.setString(9, shippingDetails.getCountry());
            cs.setString(10, productDetails.getProductName());
            cs.setBinaryStream(11, fis, (int) imageFile.length());
            cs.registerOutParameter(12, Types.BOOLEAN);
            cs.execute();
            boolean result = cs.getBoolean(12);
            System.out.println("Result: " + result);
            return result;
        } catch(SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public HashMap<Integer, Product> getSellerProductsHashMap(String sellerUsername){
        try{

            HashMap<Integer, Product> productMap = new HashMap<>();

            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info",
                    DB_USER, DB_PW);
            String q = "CALL get_seller_inventory(?,?,?,?)";
            CallableStatement cs = connection.prepareCall(q);
            cs.setString(1,username);
            cs.setString(2, password);
            cs.setString(3, sellerUsername);
            cs.registerOutParameter(4, Types.BOOLEAN);
            ResultSet rs = cs.executeQuery();

            boolean result = cs.getBoolean(4);
            System.out.println(result);
            if (!result) return null;
            while(rs.next()){
                InputStream imgStream = rs.getBlob("image").getBinaryStream();
                BufferedImage image = ImageIO.read(imgStream);

                ProductDetails productDetails = new ProductDetails(
                        rs.getInt("quantity"),
                        rs.getBigDecimal("price"),
                        rs.getBoolean("available"),
                        rs.getString("description"),
                        rs.getString("name"),
                        null
                );

                ProductShippingDetails shippingDetails = new ProductShippingDetails(
                        rs.getString("address"),
                        rs.getInt("zip"),
                        rs.getString("country")
                );

                Product product = new Product(
                        productDetails,
                        shippingDetails,
                        rs.getInt("product_id"),
                        rs.getString("seller_name"),
                        image
                );
                productMap.put(product.getID(), product);
            }
            return productMap;
        } catch(SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public boolean modifyProductEntry(int productID, ProductDetails newProductDetails,
                                   ProductShippingDetails newShippingDetails){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info",
                    DB_USER, DB_PW);
            String q = "CALL modify_product(?,?,?,?,?,?,?,?,?,?,?,?)";
            CallableStatement cs = connection.prepareCall(q);
            cs.setString(1,username);
            cs.setString(2, password);
            cs.setInt(3, productID);
            cs.setInt(4, newProductDetails.getQuantity());
            cs.setBoolean(5, newProductDetails.getAvailable());
            cs.setBigDecimal(6, newProductDetails.getPrice());
            cs.setString(7, newProductDetails.getDescription());
            cs.setString(8,newShippingDetails.getAddress());
            cs.setInt(9, newShippingDetails.getZip());
            cs.setString(10, newShippingDetails.getCountry());
            cs.setString(11, newProductDetails.getProductName());
            cs.registerOutParameter(12, Types.BOOLEAN);
            cs.execute();
            boolean result = cs.getBoolean(12);
            System.out.println("Result: " + result);
            return result;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //returns true if credentials are valid, false if invalid.
    public static LoginDetails verifyCredentials (String username, String password){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info",
                    DB_USER, DB_PW);
            String q = "CALL login(?,?,?)";
            CallableStatement cs = connection.prepareCall(q);
            cs.setString(1,username);
            cs.setString(2, password);
            cs.registerOutParameter(3, Types.BOOLEAN);
            cs.execute();
            boolean result = cs.getBoolean(3);
            if (!result){return LoginDetails.UNSUCCESSFUL;}
            else if (getUserInfo(username, password).isSeller()){return LoginDetails.SELLER;}
            else {return LoginDetails.CUSTOMER;}
        } catch(SQLException e){
            e.printStackTrace();
        }
        return LoginDetails.UNSUCCESSFUL;
    }

    private static UserInfo getUserInfo(String username, String password){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info",
                    DB_USER, DB_PW);
            String q = "CALL get_user_info(?,?)";
            CallableStatement cs = connection.prepareCall(q);
            cs.setString(1, username);
            cs.setString(2, password);
            ResultSet rs = cs.executeQuery();

            while (rs.next()){
                BigDecimal funds = rs.getBigDecimal("funds");
                boolean seller = rs.getBoolean("seller");
                int id = rs.getInt("id");
                return new UserInfo(username, password, funds, seller, id);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public UserInfo getUserInfo(){
        return getUserInfo(username, password);
    }

    public ArrayList<String> getSellerUsernames(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info",
                    DB_USER, DB_PW);
            String q = "CALL get_seller_names()";
            CallableStatement cs = connection.prepareCall(q);
            ResultSet rs = cs.executeQuery();
            ArrayList<String> nameList = new ArrayList<>();
            while(rs.next()){
                nameList.add(rs.getString("username"));
            }
            return nameList;

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }

}
