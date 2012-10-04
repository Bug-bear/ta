import java.util.Scanner;

public class Meal{
    public static void main(String[] args){
        final double VAT = 0.175;
        final double GRAT_RATE = 0.1;
        
        Scanner in = new Scanner(System.in);
        System.out.print("total: ");
        double total = in.nextDouble();
        
       double vat = total * VAT;
       double grat = total * GRAT_RATE;

       double mealPrice = total + vat + grat;
       System.out.print("Total price of meal: "+mealPrice);
    }
}