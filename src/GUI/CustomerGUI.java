package GUI;

import Product.Product;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomerGUI {


    public static void main(String[] args){
        CustomerGUI customerGUI = new CustomerGUI();
        customerGUI.init();

    }

    private JTabbedPane pane;
    private JPanel shopPanel, shopSellersPanel, shopTextPanel,
    transactionPanel, infoPanel;


    private JScrollPane scrollPane;

    public void init(){
        pane = new JTabbedPane();
        shopPanel = new JPanel();

        shopTextPanel = new JPanel();
        shopTextPanel.add(new JLabel("Shop Page"));

        shopSellersPanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 30, 30);
        shopSellersPanel.setLayout(flowLayout);




        GridBagConstraints c = new GridBagConstraints();
        shopPanel.setLayout(new GridBagLayout());


        c.gridx = 0;
        c.gridy = 0;


        //shopPanel.setLayout(new GridLayout(2,1));
        shopPanel.add(shopTextPanel, c);
        c.gridx = 0;
        c.gridy = 1;
        shopPanel.add(shopSellersPanel, c);

        scrollPane = new JScrollPane(shopPanel);


        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        pane.addTab("Shop", scrollPane);

        transactionPanel = new JPanel();
        infoPanel = new JPanel();







        pane.addTab("Transactions", transactionPanel);
        pane.add("Account Info", infoPanel);


        //Shop Panel init

    }

    public void setShops(ArrayList<String> sellerList){
        for (Component component : shopSellersPanel.getComponents()){
            if (component instanceof JButton){
                shopSellersPanel.remove(component);
            }
        }

        for (String sellerName : sellerList){
            System.out.println(sellerName);
            shopSellersPanel.add(new JButton(sellerName+"'s Shop"));
        }
    }


    JTabbedPane getTabbedPane(){
        return pane;
    }




}
