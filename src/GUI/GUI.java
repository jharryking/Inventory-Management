package GUI;

import Database.DB;
import Database.LoginDetails;
import Users.SellerAccount;
import Users.UserAccount;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener, ChangeListener {



    private LoginAccountGUI loginAccountGUI;
    private CreateAccountGUI createAccountGUI;
    private CustomerGUI customerGUI;
    private JFrame frame;
    String lastFrame;

    private UserAccount account;


    public GUI() {
        loginAccountGUI = new LoginAccountGUI();
        createAccountGUI = new CreateAccountGUI();
        customerGUI = new CustomerGUI();
        frame = new JFrame();
        account = new UserAccount("harryseller", "1245");
    }

    private void initPanels(){
        //login GUI
        loginAccountGUI.init();
        loginAccountGUI.createButton.addActionListener(this);
        loginAccountGUI.loginButton.addActionListener(this);

        //customerGUI

        customerGUI.init();
        customerGUI.getTabbedPane().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = customerGUI.getTabbedPane().getSelectedIndex();
                System.out.println("Tab Changed: " + selectedIndex);
                if (selectedIndex == 0){
                    customerGUI.setShops(account.getDb().getSellerUsernames());
                }
            }
        });

        //show frame after loginGUI loaded
        frame.setVisible(true);


        //createAccountGUI.init();
    }

    private void initFrame(){
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Inventory Management");
        frame.setVisible(false);
    }

    public void start(){
        initFrame();
        initPanels();
        //frame.setContentPane(loginAccountGUI.getPanel());
        frame.setContentPane(customerGUI.getTabbedPane());
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        System.out.println(e.getActionCommand());

        if (actionCommand.equals("Login")){
            String username = loginAccountGUI.getUsernameField();
            String password = loginAccountGUI.getPasswordFieldText();
            LoginDetails loginDetails = DB.verifyCredentials(username, password);
            if (loginDetails == LoginDetails.UNSUCCESSFUL){
                System.out.println("Unsuccessful login");
            }
            else if(loginDetails == LoginDetails.SELLER){
                account = new SellerAccount(username, password);
                System.out.println("Seller login");
                loginAccountGUI.getPanel().setVisible(false);
            }
            else if(loginDetails == LoginDetails.CUSTOMER){
                account = new UserAccount(username, password);
                System.out.println("Customer login");
            }
        }
        else if (actionCommand.equals("Create Account")) {

        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
