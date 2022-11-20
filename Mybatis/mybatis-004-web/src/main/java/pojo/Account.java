package pojo;

/**
 * 银行账户类
 */
public class Account {
    private Integer id; // id
    private String actNo; // 账号
    private Double balance; // 余额

    // 构造器
    public Account() {
    }

    public Account(Integer id, String actNo, Double balance) {
        this.id = id;
        this.actNo = actNo;
        this.balance = balance;
    }

    // getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActNo() {
        return actNo;
    }

    public void setActNo(String actNo) {
        this.actNo = actNo;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", actNo='" + actNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}
