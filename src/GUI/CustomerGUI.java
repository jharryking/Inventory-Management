package GUI;

import Product.Product;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomerGUI {

    public JPanel topShopPanel, shopSellersPanel, transactionPanel, infoPanel;
    public JButton shopButton, infoButton, myProductsButton;

    public void init(){
        topShopPanel = new JPanel();
        shopSellersPanel = new JPanel();
        transactionPanel = new JPanel();
        infoPanel = new JPanel();

        topShopPanel.setLayout(null);
        shopSellersPanel.setLayout(null);

        topShopPanel.setBounds(0,0,800,75);
        topShopPanel.setBackground(Color.cyan);

        shopButton = new JButton("Shop");
        shopButton.setBounds(0,0,100,75);
        topShopPanel.add(shopButton);

        infoButton = new JButton("Info");
        infoButton.setBounds(120,0,100,75);
        topShopPanel.add(infoButton);

        myProductsButton = new JButton("My Products");
        myProductsButton.setBounds(240,0,110,75);
        topShopPanel.add(myProductsButton);

        shopSellersPanel.setBounds(0,75,800,725);
        shopSellersPanel.setBackground(Color.BLUE);

        //Shop Panel init

    }

}
