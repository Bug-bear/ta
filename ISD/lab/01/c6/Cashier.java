import java.util.Scanner;

public class Cashier{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the amount due, in pence: ");     
        int due = in.nextInt();
        System.out.print("Enter the amount received, in pence: ");
        int received = in.nextInt();
        
        int change = received-due;
        
        int pound = change/100;
        change = change%100;
        int fifty = change/50;
        change = change%50;
        int twenty = change/20;
        change = change%20;
        int ten = change/10;
        change = change%10;
        int five = change/5;
        change = change%5;
        int two = change/2;
        change = change%2;
        int penny = change;
    }
}