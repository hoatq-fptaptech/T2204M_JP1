package assignment;

public class Account {
    private Integer id;
    private String name;
    private Double balance;

    public Account() {
    }

    public Account(Integer id, String name, Double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void credit(int amount){
       // setBalance(getBalance()+ (amount>0?amount:0));
        if(amount>0){
            double newBalance = getBalance() + amount;
            setBalance(newBalance);
        }else{
            double newBalance = getBalance() + 0;
            setBalance(newBalance);
        }
    }

    public void debit(int amount){
        //setBalance(getBalance()-(amount>0&&getBalance()>=amount?amount:0));
        if(amount > 0 && getBalance() > amount){
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
        }
    }

    public void transferTo(Account ac,int amount){
        ac.setBalance(ac.getBalance()+ (amount>0&&getBalance()>=amount?amount:0));
        this.debit(amount);
    }
}
