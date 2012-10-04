import java.util.Scanner;

public class RemoveComma
{
    public static void main(String[] args)
    {
        System.out.println("number between 1,000 and 999,999: ");
        Scanner in = new Scanner(System.in);
        String number = in.next();
        int len = number.length();
        
        System.out.println(number.substring(0,len-4) + number.substring(len-3,len));
    }
}