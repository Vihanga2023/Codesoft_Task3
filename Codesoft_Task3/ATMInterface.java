import java.util.Scanner;

class BankAccount
{
    private double balance;


    public  BankAccount(double InitialBalance)
    {
        this.balance=InitialBalance;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        if(amount > 0)
        {
            balance = balance + amount ;
            System.out.println("Successfully Deposited.");
            System.out.println("Your updated balance is:"+balance);
        }
        else
        {
            System.out.println("Invalid amount! ");
        }
    }

    public void withdraw(double amount)
    {
        if(balance >= amount)
        {
            balance=balance-amount;
            System.out.println("Successfully Withdrawed.");
            System.out.println("Your updated balance is:"+balance);
        }
        else 
        {
            System.out.println("Insufficient balance!");
        }
    }
}

class ATM
{
    private BankAccount account;

    public ATM(BankAccount account)
    {
        this.account = account;
    }

    public void Interface()
    {
        Scanner sc=new Scanner(System.in);
        double amount;
        char again;

        do
        {
            System.out.println("----------------------------------");
            System.out.println("-----Welcome to ATM Interface-----");
            System.out.println("----------------------------------");
            System.out.println("1. Balance inquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter the choice you want to perform : ");
            int choice = sc.nextInt();

            System.out.println();

            switch(choice)
            {
                case 1:
                System.out.println("Your Account balance is :"+account.getBalance());
                break;

                case 2:
                System.out.print("Enter the amount you want to depost:");
                amount=sc.nextDouble();
                account.deposit(amount);
                break;

                case 3:
                System.out.print("Enter the amount you want to withdraw:");
                amount=sc.nextDouble();
                account.withdraw(amount);
                break;

                case 4:
                System.exit(0);

                default:
                System.out.println("Invalid choice! Please enter the valid choice");
            }
            System.out.println();
            System.out.println("Do you want any other servise?");
            again = sc.next().charAt(0);
        } 
        while(again =='y' || again == 'Y');
        {
            System.out.println("Thank for using Atm. good bye!!!");
        }
    }   
}

public class ATMInterface
{
    public static void main(String args[])
    {
       BankAccount Acc = new BankAccount(1000);
       ATM atm =new ATM(Acc);
       atm.Interface();
    }
}
