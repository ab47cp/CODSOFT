import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        if (amount <= balance) 
            balance -= amount;
        else
            System.out.println("Insufficient balance !");
    }
}

class ATM {
    private final BankAccount bankAccount;

    public ATM(BankAccount account) {
        bankAccount = account;
    }

    public void options() {
        System.out.println("Welcome to Bank Of India ATM ! Please select your desired option from below : ");
        System.out.println("1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit\n");
    }

    public void action (int ch) {
        double amount;
        switch (ch){
            case 1:
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the amount to withdraw : ");
                amount = sc.nextDouble();
                withdraw(amount);
                break;
            case 2:
                Scanner sc1 = new Scanner(System.in);
                System.out.print("Enter the amount to deposit : ");
                amount = sc1.nextDouble();
                deposit(amount);
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Visit again !\n");
                System.exit(0);
                break;
            default:
                System.out.println("Please select a valid option !");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= bankAccount.getBalance()) {
                bankAccount.withdraw(amount);
                System.out.println(amount+" "+"Withdrawn successfully !\n");
            } 
            else
                System.out.println("Insufficient balance !\n");
        }
        
    }

    public void deposit(double amount) {
            bankAccount.deposit(amount);
            System.out.println(amount+" "+"Deposited successfully !\n");
    }

    public void checkBalance() {
        System.out.println("Available balance : " + bankAccount.getBalance());
        System.out.println();
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000.0);
        ATM atm = new ATM(bankAccount);
        try (Scanner sc = new Scanner(System.in)) {
            while (true){
                atm.options();
                System.out.print("Enter your choice: ");
                int option = sc.nextInt();
                atm.action(option);
            }
        }
    }
}