package GUI;


import Database.DB;
import Database.LoginDetails;
import Product.*;
import Users.SellerAccount;
import Users.UserAccount;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class GUI implements ActionListener, ChangeListener {

    private LoginAccountGUI loginAccountGUI;
    private CreateAccountGUI createAccountGUI;
    private CustomerGUI customerGUI;
    private ProductListGUI productListGUI;
    private ProductGUI productGUI;
    private CreateModifyProductGUI createModifyProductGUI;
    private String activeSeller;
    private Product activeProduct;
    private JFrame frame;

    private UserAccount account;


    public GUI() {
        loginAccountGUI = new LoginAccountGUI();
        createAccountGUI = new CreateAccountGUI();
        customerGUI = new CustomerGUI();
        productListGUI = new ProductListGUI();
        productGUI = new ProductGUI();
        createModifyProductGUI = new CreateModifyProductGUI();
        frame = new JFrame();
    }

    public void start(){
        initFrame();
        initPanels();
        //frame.setContentPane(customerGUI.getTabbedPane());
        showLoginGUI();
        //showCustomerShopGUI();
        //productListGUI.changeProductListText("Hello");
    }


    private void showProductListGUI(String sellerName){
        activeSeller = sellerName;
        productListGUI.productPane.removeAll();
        frame.getContentPane().removeAll();
        frame.add(productListGUI.topPane);
        frame.add(productListGUI.productPane);
        account.updateProductManager(sellerName);
        productListGUI.changeProductListText(sellerName+"'s Shop");
        int count = 0;
        for (Map.Entry<Integer,Product> entry : account.getProductManager().getProductMap().entrySet()){
            Product product = entry.getValue();
            if (!product.getProductDetails().getAvailable() ) continue;
            JButton button = productListGUI.addProduct(product.getProductDetails().getProductName(), product.getID(), product.getImage());
            int xpos = ( (count%4)*170) + 20;
            int ypos = ( (count/4)*130) + 20;
            button.setBounds(xpos, ypos, 170, 130);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Product product = account.getProductManager().getProduct(Integer.parseInt(e.getActionCommand()));
                    showProductGUI(product);
                }
            });
            count++;
        }
        frame.revalidate();
        frame.repaint();

        //account.updateProductManager(sellerName);
        //account.getProductManager().printProductMap();
    }


    private void showProductGUI (Product product){
        activeProduct = product;
        frame.getContentPane().removeAll();
        frame.add(productGUI.topPanel);
        frame.add(productGUI.productPanel);
        productGUI.funds.setText("Funds: $" + account.getUserInfo().getFunds());
        productGUI.quantityAvailable.setText(String.valueOf(product.getProductDetails().getQuantity()));
        productGUI.price.setText(String.valueOf(product.getProductDetails().getPrice()));
        productGUI.productNameLabel.setText(product.getProductDetails().getProductName());
        frame.revalidate();
        frame.repaint();
    }


    private void removeAllActionListeners(JButton button){

        for ( ActionListener actionListener: button.getActionListeners()){
            button.removeActionListener(actionListener);
        }
    }

    private void showCreateModifyProductGUI(){
        frame.getContentPane().removeAll();
        frame.add(createModifyProductGUI.topPanel);
        frame.add(createModifyProductGUI.productPanel);

        frame.revalidate();
        frame.repaint();
    }

    private void showCreateAccountGUI (){
        frame.getContentPane().removeAll();
        frame.add(createAccountGUI.panel);

        frame.revalidate();
        frame.repaint();

    }

    private void initPanels(){
        //login GUI
        //account = new UserAccount("harryseller", "1245");
        loginAccountGUI.init();
        loginAccountGUI.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginAccountGUI.usernameField.getText();
                String password = loginAccountGUI.passwordField.getText();
                LoginDetails loginDetails = DB.verifyCredentials(username, password);
                if (loginDetails == LoginDetails.UNSUCCESSFUL){
                    System.out.println("Unsuccessful login");
                }
                else if(loginDetails == LoginDetails.SELLER){
                    account = new SellerAccount(username, password);
                    productListGUI.createProductButton.setVisible(true);
                    customerGUI.myProductsButton.setVisible(true);
                    System.out.println("Seller login");
                    showCustomerShopGUI();
                }
                else if(loginDetails == LoginDetails.CUSTOMER){
                    account = new UserAccount(username, password);
                    productListGUI.createProductButton.setVisible(false);
                    customerGUI.myProductsButton.setVisible(false);
                    //account.addFunds(new BigDecimal(100));
                    System.out.println("Customer login");
                    showCustomerShopGUI();
                }
            }
        });


        loginAccountGUI.createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCreateAccountGUI();
            }
        });

        createAccountGUI.init();

        createAccountGUI.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginGUI();
            }
        });

        createAccountGUI.createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean seller = createAccountGUI.sellerField.isSelected();
                String username = createAccountGUI.usernameField.getText();
                String password = createAccountGUI.passwordField.getText();

                if (!DB.createAccountEntry(username, password, seller)) return;

                if (seller){
                    account = new SellerAccount(username, password);
                    productListGUI.createProductButton.setVisible(true);
                    customerGUI.myProductsButton.setVisible(true);
                }
                else{
                    account = new UserAccount(username, password);
                    productListGUI.createProductButton.setVisible(false);
                    customerGUI.myProductsButton.setVisible(false);
                }
                showCustomerShopGUI();

            }
        });

        //customer GUI
        customerGUI.init();
        customerGUI.shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCustomerShopGUI();
            }
        });

        customerGUI.myProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProductListGUI(account.getUserInfo().getUsername());
            }
        });

        createModifyProductGUI.init();
        createModifyProductGUI.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProductListGUI(activeSeller);
            }
        });
        createModifyProductGUI.createModifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int quantity = Integer.parseInt(createModifyProductGUI.quantity.getText());
                BigDecimal price = new BigDecimal(createModifyProductGUI.price.getText());
                String name = createModifyProductGUI.name.getText();
                String image = createModifyProductGUI.image.getText();

                ProductShippingDetails productShippingDetails = new ProductShippingDetails("None", 0, "US");
                ProductDetails productDetails = new ProductDetails(quantity, price, true, "None", name, image);

                if (createModifyProductGUI.createModifyButton.getText().equals("Create")){
                    SellerAccount sellerAccount = new SellerAccount(account.getUserInfo().getUsername(), account.getUserInfo().getPassword());
                    sellerAccount.createProduct(productDetails, productShippingDetails);
                }

            }
        });




        //Product List GUI
        productListGUI.init();

        productListGUI.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCustomerShopGUI();
            }
        });


        productListGUI.createProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCreateModifyProductGUI();
            }
        });

        productGUI.init();

        productGUI.buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (productGUI.purchaseQuantity.getText().equals("")) return;
                boolean result = account.purchaseProduct(activeProduct, Integer.parseInt(productGUI.purchaseQuantity.getText()));
                showProductGUI(account.getProductManager().getProduct(activeProduct.getID()));
            }
        });

        productGUI.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProductListGUI(activeSeller);
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
        frame.setResizable(false);
        frame.setLayout(null);
    }


    private void showCustomerShopGUI(){
        frame.getContentPane().removeAll();
        ArrayList<String> sellerList = account.getDb().getSellerUsernames();
        frame.add(customerGUI.topShopPanel);
        frame.add(customerGUI.shopSellersPanel);
        for (int i = 0; i< sellerList.size(); i++){
            String sellerName = sellerList.get(i);
            int xpos = ( (i%4)*170) + 20;
            int ypos = ( (i/4)*20) + 20;
            JButton button = new JButton(sellerName + "'s Shop");
            button.setBounds(xpos, ypos, 160, 75);
            customerGUI.shopSellersPanel.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showProductListGUI(sellerName);
                }
            });
        }
        frame.revalidate();
        frame.repaint();
    }

    private void showLoginGUI(){
        frame.getContentPane().removeAll();
        frame.add(loginAccountGUI.panel);

        frame.revalidate();
        frame.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
