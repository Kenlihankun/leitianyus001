package heima_8;

public class Account {
    private String Cardid;
    private String username;
    private String password;
    private double money;
    private double quotamoney;

    public Account() {
    }

    public Account(String cardid, String username, String password, double money, double quotamoney) {
        Cardid = cardid;
        this.username = username;
        this.password = password;
        this.money = money;
        this.quotamoney = quotamoney;
    }

    public String getCardid() {
        return Cardid;
    }

    public void setCardid(String cardid) {
        Cardid = cardid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getQuotamoney() {
        return quotamoney;
    }

    public void setQuotamoney(double quotamoney) {
        this.quotamoney = quotamoney;
    }
}
