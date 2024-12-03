package Database;

import java.math.BigDecimal;
import java.sql.*;

public class DB {
    private static String DB_USER = "guest";
    private static String DB_PW = "";
    private static String userName;
    private static String userPassword;


    public static void main(String[] args){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info",
                    DB_USER, DB_PW);
            System.out.println("Successful connection");


            /*
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USER_DATA");


            while (resultSet.next()){
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("password"));
                System.out.println(resultSet.getInt("id"));
            }
             */

            //createAccount("harryseller", "1245", true);
            login("harryseller", "1245");
            createProduct (10, true, 30.00, "",
                    "address",15413, "US", "product1");
        } catch(SQLException e){
            e.printStackTrace();
        }
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




}
