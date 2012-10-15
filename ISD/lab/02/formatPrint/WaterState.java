import java.util.Scanner;

public class WaterState
{
   public static void main(String[] args)
   {

      final double WATER_FREEZE_TEMP_C = 0; // freezing temperature in Centigrade
      final double WATER_FREEZE_TEMP_F = 32; // freezing temperature in Farenheit 

      final double WATER_BOIL_TEMP_C = 100; // boiling temperature in Centigrade
      final double WATER_BOIL_TEMP_F = 212; // boiling temperature in Farenheit 

      Scanner in = new Scanner(System.in);

      System.out.print("Enter temperature: ");
      double temp = in.nextDouble();

      System.out.print("Enter C for Centigrade or F for Fahrenheit: ");
      String type = in.next();

      if (type.equals("C")) {
      //if (type.compareTo("C") == 0) {
         // Centigrade
         if (temp > WATER_BOIL_TEMP_C) {
            System.out.println("It's a gas.");
         }
         else if (temp > WATER_FREEZE_TEMP_C) {
            System.out.println("It's a liquid.");
         }
         else {
            System.out.println("It's a solid.");
         }
      }
      else if (type.compareTo("F") == 0)
      {
         // Fahrenheit
         if (temp > WATER_BOIL_TEMP_F) {
            System.out.println("It's a gas.");
         }
         else if (temp > WATER_FREEZE_TEMP_F) {
            System.out.println("It's a liquid.");
         }
         else {
            System.out.println("It's a solid.");
         }
      }
      else {
         System.out.println("Invalid input.");      
      }
   }
}