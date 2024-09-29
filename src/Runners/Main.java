package Runners;
import Users.Manufacturer;
import Users.UserManager;
import Utilities.*;

public class Main {
    public static void main(String[] args){
        int loginSelection = -1;

        do{

            System.out.print("""
                Log in as a
                1. Manufacturer
                2. Retailer
                3. Customer
                Please enter the corresponding number: """);

            loginSelection = Utilities.input.nextInt();


        } while(loginSelection != 1 && loginSelection !=2 && loginSelection !=3);

        new

        UserManager userManager = new UserManager();
        switch (loginSelection){
            case 1:
                userManager = new UserManager();
                break;
            case 2:
                break;
            case 3:

                break;
            default:

        }

    }
}
