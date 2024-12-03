package Accounts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserAccount {
    protected double funds;
    protected String username;
    protected String password;

    public boolean login() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_info",
                 "root", "");




        connection.close();
        return true;
    }

    public boolean logout(){
        return true;
    }



}
