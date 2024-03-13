import java.util.Random;

class BankAccount {
    private long accountNumber;
    private double amount;
    private char type;

    public BankAccount(long accountNumber, char type) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = 0;
    }
    public long getAccountNumber() {
        return accountNumber;
    }

    public char getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public void deposit(double amount) {
        if (type == 'A') {
            if (this.amount + amount <= 50000) {
                this.amount += amount;
            } else {
                System.out.println("No puede tener más de 50,000 cuenta A");
            }
        } else if (type == 'B') {
            if (this.amount + amount <= 100000) {
                this.amount += amount;
            } else {
                System.out.println("No puede tener más de 100,000 cuenta B");
            }
        } else {
            this.amount += amount;
        }
    }

    public void withdraw(double amount) {
        double minBalance = 0;
        if (type == 'A') {
            minBalance = 1000;
        } else if (type == 'B') {
            minBalance = 5000;
        } else {
            minBalance = 10000;
        }

        if (this.amount - amount >= minBalance) {
            this.amount -= amount;
        } else {
            System.out.println("No puede retirar esa cantidad, saldo insuficiente o mínimo no alcanzado.");
        }
    }
    public static long CreacionaccountNumber(){
        Random ran=new Random();
        long accountNumber= ran.nextLong(99999)+10000;
        return accountNumber;}

}