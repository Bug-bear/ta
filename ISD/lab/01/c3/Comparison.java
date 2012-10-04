import java.util.Scanner;

public class Comparison{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("give me 2 integers");
        int a = in.nextInt();
        int b = in.nextInt();
        
        System.out.println("sum = " + (a+b));
        System.out.println("Diff = " + (a-b));
        System.out.println("Prod = " + (a*b));
        System.out.println("Average = " + (a+b)/2.0);
        System.out.println("Larger = " + Math.max(a,b));
        System.out.println("Smaller = " + Math.min(a,b));
    }
}