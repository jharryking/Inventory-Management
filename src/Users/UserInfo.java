package Users;

import java.math.BigDecimal;

public class UserInfo {

    private BigDecimal funds;
    private String username;
    private String password;
    private boolean seller;
    private int id;

    public UserInfo(String username, String password, BigDecimal funds,
                    boolean seller, int id){
        this.funds = funds;
        this.username = username;
        this.password = password;
        this.seller = seller;
        this.id =id;
    }

    public void print(){
        System.out.println("Account Details:");
        System.out.println("Username: " + username + " | Funds: " + funds);
    }

    public String getPassword() {
        return password;
    }

    public BigDecimal getFunds (){
        return funds;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public boolean isSeller() {
        return seller;
    }

}
