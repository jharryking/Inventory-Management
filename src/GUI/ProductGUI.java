package GUI;

import javax.swing.*;
import java.awt.*;

public class ProductGUI {


    public JPanel topPanel;
    public JPanel productPanel;

    public JTextField purchaseQuantity;
    public JButton backButton, modifyButton, buyButton;

    public JLabel quantityAvailable, price, productNameLabel, funds;

    public void init(){

        topPanel = new JPanel();
        productPanel = new JPanel();

        topPanel.setLayout(null);
        productPanel.setLayout(null);

        topPanel.setBounds(0,0,800,75);
        topPanel.setBackground(Color.CYAN);

        productPanel.setBounds(0,75,800,725);
        productPanel.setBackground(Color.BLUE);

        Font labelFont  = new java.awt.Font("Arial", Font.BOLD, 20);
        Font productNameFont  = new java.awt.Font("Arial", Font.BOLD, 30);


        productNameLabel = new JLabel();
        productNameLabel.setBounds(300,0,200,50);
        productNameLabel.setHorizontalAlignment(JLabel.CENTER);
        productNameLabel.setFont(productNameFont);
        productNameLabel.setText("Product");
        productPanel.add(productNameLabel);

        JLabel quantityAvailLabel = new JLabel("Quantity Available:");
        quantityAvailLabel.setBounds(200,100,200,50);
        quantityAvailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        quantityAvailLabel.setFont(labelFont);
        productPanel.add(quantityAvailLabel);

        quantityAvailable = new JLabel("0");
        quantityAvailable.setBounds(410,100,200,50);
        quantityAvailable.setHorizontalAlignment(SwingConstants.LEFT);
        quantityAvailable.setFont(labelFont);
        productPanel.add(quantityAvailable);


        JLabel purchaseAvailQuantity = new JLabel("Purchase Quantity:");
        purchaseAvailQuantity.setBounds(200,150,200,50);
        purchaseAvailQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
        purchaseAvailQuantity.setFont(labelFont);
        productPanel.add(purchaseAvailQuantity);

        purchaseQuantity = new JTextField(9);
        purchaseQuantity.setBounds(410,150,200,50);
        purchaseQuantity.setHorizontalAlignment(JTextField.LEFT);
        purchaseQuantity.setFont(labelFont);
        productPanel.add(purchaseQuantity);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(200,200,200,50);
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        priceLabel.setFont(labelFont);
        productPanel.add(priceLabel);

        price = new JLabel("0");
        price.setBounds(410,200,200,50);
        price.setHorizontalAlignment(SwingConstants.LEFT);
        price.setFont(labelFont);
        productPanel.add(price);


        buyButton = new JButton("Purchase");
        buyButton.setBounds(300,350,200,50);
        buyButton.setFont(labelFont);
        productPanel.add(buyButton);

        funds = new JLabel("0");
        funds.setFont(labelFont);
        funds.setBounds(550,0,350, 100);
        topPanel.add(funds);

        backButton = new JButton("Back");
        backButton.setBounds(0,0,100, 75);
        topPanel.add(backButton);
    }

}