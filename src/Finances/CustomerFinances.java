package Finances;

public class CustomerFinances extends BaseFinances{
    CustomerFinances(){
        super();
    }
    CustomerFinances(double funds){
        super(funds);
    }

    public boolean purchaseObject(int sellerID, int productID){
        return true;
    }






}

