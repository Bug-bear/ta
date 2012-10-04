import java.util.Scanner;

public class Rectangle{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("width");
        double width = in.nextDouble();
        System.out.println("height");
        double height = in.nextDouble();
    
        System.out.println("area = " + (width*height));
        System.out.println("perimeter = " + 2*(width+height));
    }
}