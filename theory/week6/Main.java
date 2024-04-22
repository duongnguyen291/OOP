
class bank{
    private String name;
    private int id;
    private double money;
    public bank(String name, int id, double money){
        this.name = name;
        this.id = id;
        this.money = Math.max(money,50000);
    }
    public void deposit(int amount){
        if(amount > 0){
            money += amount;
        }
    }
    public int withdraw(int amount){
        if(amount > 0){
            int totalMoney = amount + 5000;
            if(money >= totalMoney){
                money -=totalMoney;
                return amount;
            }
            else{
                System.out.println("Insufficient funds");
                return 0;
            } 
        }
        else return 0;
    }
    public void increaseBalance(int amount){
        if(amount > 0){
            money += amount;
        }
    }
    public void decreaseBalance(int amount){
        if(amount > 0 && money >= amount){
            money -= amount;
        }
        else{
            System.out.println("Insufficient funds");
        }
    }
    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }
    public double getBalance(){
        return this.money;
    }
}

class SavingAccount extends bank{
    private double annualInterestRate;
    public SavingAccount(String name, int id, double money, double annualInterestRate) {
        super(name, id, money);
        this.annualInterestRate = annualInterestRate;
    }

    public double calculateMonthlyInterest() {
        return getBalance() * (annualInterestRate / 12);
    }
}
public class Main{
    public static void main(String[] args) {
        bank DuongDzAccount = new bank("Nguyen Dinh Duong", 20225966, 100000);
        DuongDzAccount.deposit(50000);
        DuongDzAccount.withdraw(20000);
        System.out.println(DuongDzAccount.getBalance());  //Output: 125000.0

        SavingAccount savingAcc = new SavingAccount("Nguyen Dinh Duong",20225966, 1500000, 0.05); // 5% annual interest rate
        savingAcc.deposit(100000);
        System.out.println(savingAcc.calculateMonthlyInterest()); // Output: 6666.666666666667
    }
}