/*
 * Author: Sotiris Stylianou (G20967429)
 * Email: sstylianou2@uclan.ac.uk
 * Description: The user input a value to the program and the program returns your bank account balance
 * To compile the program: Press Run
 * To run the program: Enter a value on run
 */

import java.util.Scanner;

public class ATMCash {
    static int withdraw( int new_balance)
    {
        int min,max;
        boolean a=true;
        Scanner scan = new Scanner(System.in);
        {
            System.out.println("Enter amount of money to be withdrawn: ");
            int cash = scan.nextInt();
            if (cash==0) return -1;
            if (new_balance < cash) {                                                                                           /* if balance is less than the cash you want to withdraw program tells you transaction failed */
                System.out.println("[!] Your transaction cannot be processed - Insufficient funds!");
            } else {                                                                                                             /* If everything is okay (the balance is not 0 or the cash is not bigger that the money) */
                for (int i = 0; i < cash; i++)                                                                                   /* Program finds if it can give 20s and 50s banknotes and the amount of them */
                    for (int j = 0; j < cash; j++)
                        if (j * 50 + i * 20 == cash) {
                            System.out.println("[ Please collect your money: " + j + " of 50 EUR, and " + i + " of 20 EUR ]");
                            i = cash;
                            j = cash;
                            a = false;
                        }
                boolean c=false,d=false;
                if (a) {                                                                                                        /* If te program cannot give 20s and 50s banknotes it finds the max and min amount that it can give*/
                    do{
                        if (cash%10!=0){
                        if (cash<20)
                        {
                            min=0;
                            max=20;
                        }
                        else if (cash<40)
                        {
                            min=20;
                            max=40;
                        }
                        else if (cash<50)
                        {
                            min=40;
                            max=50;
                        }
                        else {
                            double cash2= (double) cash/10;
                            min=(int) (Math.floor(cash2)*10);
                            max=(int) (Math.ceil(cash2)*10);
                        }
                        System.out.println("The ATM can only release a total amount of " + min + " EUR or " + max + " EUR.");
                        System.out.println("[ Your current balance is: " + new_balance + " EUR ]");
                        System.out.println("Enter your preferred amount of money to be withdrawn: ");
                        cash = scan.nextInt();
                        if (cash==0)
                        {
                            break;
                        }
                        if (cash>new_balance){
                            System.out.println("[!] Your transaction cannot be processed - Insufficient funds!");
                            System.out.println("Enter amount of money to be withdrawn: ");
                            cash=scan.nextInt();
                            do{
                                if (cash>new_balance){
                                    System.out.println("[!] Your transaction cannot be processed - Insufficient funds!");
                                    System.out.println("Enter amount of money to be withdrawn: ");
                                    cash=scan.nextInt();
                                }
                                else d=true;
                            }while (!d);}}
                        else {
                            for (int i = 0; i< cash; i++)                                                                                  /* Program finds again the 20s and 50s banknotes that it can give */
                                for (int j = 0; j< cash; j++)
                                    if (j*50+i*20== cash) {
                                        System.out.println("[ Please collect your money: " + j + " of 50 EUR, and " + i + " of 20 EUR ]");
                                        i = cash;
                                        j = cash;
                                        c=true;
                                    }}
                    }while (!c);
                }

            }
            new_balance=new_balance-cash;
        }

        return new_balance;                                                                                                    /* Program returns the new balance */
    }
    public static void main(String[] args) {
        int balance , choice = 0, new_balance = 0,c=0;                                                                          /*Balance is the cash that user gives to the program each time, choice is whether the user chooses 1,2,3 or 4, new_balance is the total balance and c is just a checker so the user can't choose to withdraw money as a first choice */
        while (choice != 4) {
            System.out.println("====================================");
            System.out.println("Automatic Teller Machine - Main Menu");
            System.out.println("====================================");
            System.out.println("        > 1 to Withdraw");
            System.out.println("        > 2 to Deposit");
            System.out.println("        > 3 to Check Balance");
            System.out.println("        > 4 to Exit");
            System.out.println("Choose the operation you want to perform:[1-4]");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();                                                                                                               /* choose the case for the switch statement */
            switch (choice) {
                case 1 :
                    if (c==0)
                        System.out.println("You have to deposit first");
                        else{
                    if (new_balance==0)
                        System.out.println("[!] Your transaction cannot be processed - Insufficient funds!");
                    else {
                        int a=withdraw(new_balance);                                                                                           /* Program calls a function named withdraw to withdraw money*/
                        if (a>=0)                                                                                                                      /* If the balance is bigger or equal than 0 program outputs this */
                        {
                            new_balance=a;
                            System.out.println("[ Your new balance is: " + a + " EUR ]");
                        }                                                                                                                              /* If the balance is less than 0 the program outputs this*/
                        else
                            System.out.println("[ Your current balance is: " + new_balance + " EUR ]");}}
                    break;
                case 2 : System.out.println("Enter amount of money to be deposited:");                                                                /* you enter the amount you want to deposit */
                    balance = scan.nextInt();
                    new_balance = new_balance + balance;
                    c++;
                    System.out.println("[ Your money has been successfully deposited. Your new balance is: " + new_balance + " EUR ]");
                    break;
                case 3 : System.out.println("[ Current Balance: " + new_balance + " ]");                                                            /* program tells you your current balance*/
                    break;
                case 4: break;
            }
        }
    }
}