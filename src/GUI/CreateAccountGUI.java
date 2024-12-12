package GUI;

import javax.swing.*;
import java.awt.*;

public class CreateAccountGUI {
    public JPanel panel;
    JButton createButton;
    JButton loginButton;
    public JTextField usernameField;
    public JTextField passwordField;
    public JCheckBox sellerField;

    void init(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,800,600);
        panel.setBackground(Color.BLUE);
        Font labelFont = new java.awt.Font("Arial", Font.BOLD, 30);
        Font textFieldFont = new java.awt.Font("Arial", Font.PLAIN, 20);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelFont);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);

        usernameField = new JTextField(15);
        usernameField.setFont(textFieldFont);
        passwordField = new JTextField(15);
        passwordField.setFont(textFieldFont);


        usernameLabel.setBounds(150,100,200,50);
        usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        usernameLabel.setFont(labelFont);
        panel.add(usernameLabel);

        usernameField = new JTextField(9);
        usernameField.setBounds(360,100,200,50);
        usernameField.setHorizontalAlignment(JTextField.LEFT);
        usernameField.setFont(labelFont);
        panel.add(usernameField);

        passwordLabel.setBounds(150,200,200,50);
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordLabel.setFont(labelFont);
        panel.add(passwordLabel);

        passwordField = new JTextField(9);
        passwordField.setBounds(360,200,200,50);
        passwordField.setHorizontalAlignment(JTextField.LEFT);
        passwordField.setFont(labelFont);
        panel.add(passwordField);


        JLabel sellerLabel = new JLabel("Seller: ");
        sellerLabel.setBounds(150,300,200,50);
        sellerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        sellerLabel.setFont(labelFont);
        panel.add(sellerLabel);

        sellerField = new JCheckBox();
        sellerField.setBounds(360,300,50,50);
        sellerField.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(sellerField);

        createButton = new JButton("Create");
        createButton.setFont(labelFont);
        createButton.setBounds(300,400,200,50);
        panel.add(createButton);

        loginButton = new JButton("Click here to be sent to login screen");
        //createButton.setFont(labelFont);
        loginButton.setBounds(245,500,300,50);
        panel.add(loginButton);

    }
}
