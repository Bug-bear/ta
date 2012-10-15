import java.util.Scanner;

public class playWithPrint{
    public static void main(String[] args){
        System.out.println("01234567890123456789");
        System.out.printf("%16.3f\n", 1234567890.12);
        //System.out.printf("%-16.2f\n", 1234567890.12);
        System.out.printf("%16s\n", "1234567890.12");
        System.out.printf("%016.3f\n", 1234567890.12);
        System.out.printf("%+16.3f\n", 1234567890.12);
        System.out.printf("%+,16.3f\n", 1234567890.12);
    }
}