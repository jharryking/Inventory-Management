package GUI;

import javax.swing.*;
import java.awt.*;

public class CreateModifyProductGUI {

    public JPanel topPanel;
    public JPanel productPanel;

    public JTextField name, price, quantity, image;
    public JButton backButton, createModifyButton;

    public void init(){

        topPanel = new JPanel();
        productPanel = new JPanel();

        topPanel.setLayout(null);
        productPanel.setLayout(null);

        topPanel.setBounds(0,0,800,75);
        topPanel.setBackground(Color.CYAN);

        productPanel.setBounds(0,75,800,725);
        productPanel.setBackground(Color.BLUE);

        Font labelFont = new java.awt.Font("Arial", Font.BOLD, 20);


        JLabel productNameLabel = new JLabel("Product Name:");
        productNameLabel.setBounds(200,100,200,50);
        productNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        productNameLabel.setFont(labelFont);
        productPanel.add(productNameLabel);

        name = new JTextField(9);
        name.setBounds(410,100,200,50);
        name.setHorizontalAlignment(JTextField.LEFT);
        name.setFont(labelFont);
        productPanel.add(name);

        JLabel productPriceLabel = new JLabel("Product Price:");
        productPriceLabel.setBounds(200,150,200,50);
        productPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        productPriceLabel.setFont(labelFont);
        productPanel.add(productPriceLabel);

        price = new JTextField(9);
        price.setBounds(410,150,200,50);
        price.setHorizontalAlignment(JTextField.LEFT);
        price.setFont(labelFont);
        productPanel.add(price);

        JLabel quantityLabel = new JLabel("Product Quantity:");
        quantityLabel.setBounds(200,200,200,50);
        quantityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        quantityLabel.setFont(labelFont);
        productPanel.add(quantityLabel);

        quantity = new JTextField(9);
        quantity.setBounds(410,200,200,50);
        quantity.setHorizontalAlignment(JTextField.LEFT);
        quantity.setFont(labelFont);
        productPanel.add(quantity);

        JLabel imageLabel = new JLabel("Product Image:");
        imageLabel.setBounds(200,250,200,50);
        imageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        imageLabel.setFont(labelFont);
        productPanel.add(imageLabel);

        image = new JTextField(9);
        image.setBounds(410,250,200,50);
        image.setHorizontalAlignment(JTextField.LEFT);
        image.setFont(labelFont);
        productPanel.add(image);



        backButton = new JButton("Back");
        backButton.setBounds(0,0,100, 75);
        topPanel.add(backButton);

        createModifyButton = new JButton("Create");
        createModifyButton.setBounds(300,350,200,50);
        createModifyButton.setFont(labelFont);
        productPanel.add(createModifyButton);




    }

}