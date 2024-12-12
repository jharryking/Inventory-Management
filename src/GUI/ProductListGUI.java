package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ProductListGUI {

    public JPanel topPane, productPane;
    public JButton backButton, createProductButton;
    private JLabel sellerNameText;


    public void changeProductListText(String text){
        sellerNameText.setText(text);
        System.out.println(sellerNameText.getText());
    }

    public JButton addProduct(String productName, int productID, BufferedImage image){
        ImageIcon icon = new ImageIcon(image);
        JButton button = new JButton(productName, icon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        productPane.add(button);
        button.setActionCommand(String.valueOf(productID));
        return button;
    }

    public void init(){

        topPane = new JPanel();
        topPane.setLayout(null);
        topPane.setBounds(0,0,800,75);
        topPane.setBackground(Color.CYAN);
        backButton = new JButton("Back");
        backButton.setBounds(0,0,100, 75);

        sellerNameText = new JLabel("Seller: sadfasdfasdf");
        sellerNameText.setBounds(110,0,700, 75);
        Font labelFont = new java.awt.Font("Arial", Font.BOLD, 30);
        sellerNameText.setFont(labelFont);
        topPane.add(backButton);
        topPane.add(sellerNameText);

        productPane = new JPanel();
        productPane.setLayout(null);
        productPane.setBounds(0,75,800,725);
        productPane.setBackground(Color.BLUE);

        createProductButton = new JButton();
        createProductButton.setBounds(600,0, 150, 75);
        createProductButton.setText("Create Product");
        topPane.add(createProductButton);

        /*

                backButton = new JButton("Back");
        textPanel.add(backButton);





        textPanel.setBackground(Color.RED);
        System.out.println(textPanel.getSize());



        productListText = new JLabel();
        Font labelFont  = new java.awt.Font("Arial", Font.BOLD, 30);
        productListText.setFont(labelFont);
        productListText.setForeground(Color.BLUE);
        productListText.setText("test");

        mainPanel.add(productListText);


        mainPanel.add(textPanel);
        mainPanel.add(productListPanel);


                GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.anchor = GridBagConstraints.NORTH;


                mainPanel.setLayout(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(textPanel, c);
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(productListPanel, c);

         */

    }


}
