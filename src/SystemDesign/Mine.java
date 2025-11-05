package SystemDesign;

import java.util.Scanner;
import java.util.Date;
import java.math.BigDecimal;


public class Mine{
    public static void displayMenu() {
        System.out.println("\nPersonal Finance Tracker");
        System.out.println("1. Add Income");
        System.out.println("2. Add Expense");
        System.out.println("3. View Report");
        System.out.println("4. Exit");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        Account myAccount = new Account();
        while(input!=4){
            displayMenu();
            input = Integer.valueOf(sc.nextLine()); //avoiding that NumberFormatException eating up the buffer on the nextLine
            String category;
            Date date;
            Transaction t;
            BigDecimal amt;
            switch(input){
                case 1:
                    System.out.println("How much income did you earn?:");
                    amt = new BigDecimal(String.valueOf(sc.nextLine()));
                    System.out.println("And how did you earn this income?:");
                    category = String.valueOf(sc.nextLine());
                    date = new Date();
                    t = new Income(amt,date.toString(),category);
                    myAccount.addTransaction(t);
                    break;
                case 2:
                    System.out.println("How much expenses did you incur?:");
                    amt = new BigDecimal(String.valueOf(sc.nextLine()));
                    System.out.println("And how did you incur this expense?:");
                    category = String.valueOf(sc.nextLine());
                    date = new Date();
                    t = new Expense(amt,date.toString(),category);
                    myAccount.addTransaction(t);
                    break;
                case 3:
                    ReportGenerator rg = new ConcreteReportGenerator();
                    rg.generateReport(myAccount);
                    break;
                case 4:
                    input = 4; break;
                default:
                    input = 0; break;
            }
        }
        sc.close();
    }
}