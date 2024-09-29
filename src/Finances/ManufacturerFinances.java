package Finances;

import Material.*;
import Product.ProductManager;

import java.util.Enumeration;

public class ManufacturerFinances extends BaseSellerFinances{
    MaterialManager materialManager;
    public ManufacturerFinances(ProductManager productManager, MaterialManager materialManager) {
        super(productManager);
        init(materialManager);

    }
    public ManufacturerFinances(ProductManager productManager, MaterialManager materialManager, double funds){
        super(productManager, funds);
        init(materialManager);
    }


    private void init(MaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    public double getTotalMaterialCost () {
        double totalCost = 0;

        Enumeration<Material> enumeration = materialManager.getProductDict().elements();
        while (enumeration.hasMoreElements()) {
            Material material = enumeration.nextElement();
            totalCost += material.getPrice() * material.getQuantity();
        }

        return totalCost;
    }

    public void generateMaterialsReport(){
        System.out.println("ID: " + super.getID());
        System.out.println("Total Funds: " + super.getFunds());
        System.out.println("Total cost of materials in inventory: " + getTotalMaterialCost());
    }

    public void generateInventoryReport(){
        System.out.println("ID: " + super.getID());
        System.out.println("Total Funds: " + super.getFunds());
        double totalMaterialCost = getTotalMaterialCost();
        System.out.println("Total cost of materials in inventory: " + totalMaterialCost);
        double totalProductCost = getTotalProductCost();
        System.out.println("Total cost of products in inventory: " + totalProductCost);
        double totalInventoryCost = totalMaterialCost + totalProductCost;
        System.out.println("Total cost of inventory: " + totalInventoryCost);

    }



}
