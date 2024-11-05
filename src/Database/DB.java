package Database;

import java.sql.*;

public class DB {
    private static String DB_USER = "guest";
    private static String DB_PW = "";


    public static void main(String[] args){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://75.102.79.120/login",
                    DB_USER, DB_PW);

            System.out.println("Successful connection");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USER_DATA");


            while (resultSet.next()){
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("password"));
                System.out.println(resultSet.getInt("id"));
            }

            System.out.println(login("username", "password"));

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static boolean login (String username, String password){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login",
                    DB_USER, DB_PW);

            String q = "SELECT * FROM USER_DATA WHERE USERNAME = ? AND PASSWORD = ?";
            PreparedStatement checkLogin = connection.prepareStatement(q);
            checkLogin.setString(1, username);
            checkLogin.setString(2, password);

            ResultSet resultSet = checkLogin.executeQuery();

            if (!resultSet.next()){
                return false;
            }


        } catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }


}
