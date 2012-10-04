import java.util.Scanner;

public class Powers{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("give me a window");
        double input = in.nextDouble();
        
        double square = Math.pow(input,2);
        System.out.print("Square: ");
        System.out.println(square);

        double cube = Math.pow(input,3);
        System.out.print("Cube: ");
        System.out.println(cube);

        double fourthPower = Math.pow(input,4);
        System.out.print("Fourth power: ");
        System.out.println(fourthPower);
    }
}