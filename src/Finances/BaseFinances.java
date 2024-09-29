package Finances;

public abstract class BaseFinances {

    protected double funds = 0;
    protected int id;
    private static int totalIDs = 0;

    BaseFinances(){
        init(0);
    }

    BaseFinances(double funds){
        init(funds);

    }

    private void init(double funds){
        this.funds = funds;
        id = ++totalIDs;
    }

    public void withdrawFunds(double withdrawAmt){
        if (withdrawAmt < funds){
            System.out.println("Tried to withdraw more than available funds");
        }
        funds -= withdrawAmt;
    }

    public int getID(){
        return id;
    }

    public double getFunds(){
        return funds;
    }

    public void depositFunds(double depositAmt){
       if (depositAmt < 0){
           System.out.println("Tried to deposit a negative amount");
           return;
       }

       funds += depositAmt;
    }


}
