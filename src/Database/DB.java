package Database;


import java.math.BigDecimal;
import java.sql.*;

public class DB {
    private static String DB_USER = "guest";
    private static String DB_PW = "";
    public static String userName;
    public static String userPassword;
    public static BigDecimal funds;


    public static void main(String[] args){
        //createAccount("harryseller", "1245", true);
        login("harryseller", "1245");
        //updateUserDetails();
        purchaseProduct(5, 10);
        //createProduct (10, true, 30.00, "",
        //        "address",15413, "US", "product1");

        //getCustomerProducts();

    }


    public static boolean purchaseProduct(int productID, int purchaseQuantity){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info",
                    DB_USER, DB_PW);
            String q = "CALL purchase_product(?,?,?,?,?)";
            CallableStatement cs = connection.prepareCall(q);
            cs.setString(1,userName);
            cs.setString(2, userPassword);
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


    public static boolean createAccount (String username, String password, boolean seller){
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
            if (result){
                userName = username;
                userPassword = password;
            }
            System.out.println("Result: " + result);
            return result;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public static boolean login (String username, String password){
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
            if (result){
                userName = username;
                userPassword = password;
            }
            System.out.println("Result: " + result);
            return result;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static void updateUserDetails(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info",
                    DB_USER, DB_PW);
            String q = "CALL get_user_info(?,?)";
            CallableStatement cs = connection.prepareCall(q);
            cs.setString(1, userName);
            cs.setString(2, userPassword);
            ResultSet rs = cs.executeQuery();

            while(rs.next()){
                funds = rs.getBigDecimal("funds");
                System.out.println(funds);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    public static boolean createProduct (int quantity, boolean available, double price,
                                         String description, String address, int zip,
                                         String country, String name){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info",
                    DB_USER, DB_PW);
            String q = "CALL create_product(?,?,?,?,?,?,?,?,?,?,?)";
            CallableStatement cs = connection.prepareCall(q);
            cs.setString(1,userName);
            cs.setString(2, userPassword);
            cs.setInt(3, quantity);
            cs.setBoolean(4, available);
            cs.setBigDecimal(5, BigDecimal.valueOf(price));
            cs.setString(6, description);
            cs.setString(7, address);
            cs.setInt(8, zip);
            cs.setString(9, country);
            cs.setString(10, name);
            cs.registerOutParameter(11, Types.BOOLEAN);
            cs.execute();
            boolean result = cs.getBoolean(11);
            System.out.println("Result: " + result);
            return result;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public static boolean getCustomerProducts(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info",
                    DB_USER, DB_PW);
            String q = "CALL get_customer_products()";
            CallableStatement cs = connection.prepareCall(q);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("seller_name"));
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;

    }



}
