import java.util.ArrayList;

class Employee {
    private String name;
    private String lastName;
    private ArrayList<BankAccount> accounts;

    public Employee(String name, String lastName, long accountNumber, char type) {
        this.name = name;
        this.lastName = lastName;
        this.accounts = new ArrayList<>();
        accountNumber=BankAccount.CreacionaccountNumber();
        addAccount(accountNumber, type);
    }

    public void addAccount(long accountNumber, char type) {
        BankAccount.CreacionaccountNumber();
        accounts.add(new BankAccount(accountNumber, type));
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }
}
