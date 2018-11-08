import java.util.Random;

public class Account {

    private int id;
    private final int bound=1000;

    private double amount;
    public Currency value;

    public Account(Currency value) {
        amount=0;
        this.value = value;
        Random randNumber = new Random();
        id = randNumber.nextInt(bound) + 1;
    }

    public int getId(){
        return id;
    }

    public double getAmount(){
        return this.amount;
    }


    public void addAmount(double x) {
        amount+=x;
    }

    public void subAmount(double x) {
        amount-=x;
    }


    public String getCurrencyName(){
        return value.name();
    }


}
