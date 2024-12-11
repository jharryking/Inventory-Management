package GUI;

import javax.swing.*;
import java.awt.*;

public class LoginAccountGUI {

    private JPanel panel;
    JButton createButton;
    JButton loginButton;
    private JTextField usernameField;
    private JTextField passwordField;

    public String getPasswordFieldText() {
        return passwordField.getText();
    }

    public String getUsernameField(){
        return usernameField.getText();
    }

    JPanel getPanel(){
        return panel;
    }

    void init(){
        panel = new JPanel();

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

        loginButton = new JButton("Login");
        loginButton.setFont(labelFont);
        createButton = new JButton("Click here to be sent to account creation");

        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(new GridBagLayout());

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.insets =  new Insets (0,0,0,0);
        panel.add(usernameLabel , c);

        c.gridx = 1;
        c.gridy = 1;
        c.insets =  new Insets (0,20,0,0);
        panel.add(usernameField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.insets =  new Insets (20,0,0,0);
        panel.add(passwordLabel , c);

        c.gridx = 1;
        c.gridy = 2;
        c.insets =  new Insets (20,20,0,0);
        panel.add(passwordField, c);


        c.gridx = 1;
        c.gridy = 3;
        c.fill = GridBagConstraints.NONE;
        c.insets =  new Insets (20,0,0,0);
        panel.add(loginButton, c);

        c.gridx = 1;
        c.gridy = 4;
        c.fill = GridBagConstraints.NONE;
        c.insets =  new Insets (20,0,0,0);
        panel.add(createButton, c);

        panel.setVisible(true);
        System.out.println("VISIBLE");

    }
}
