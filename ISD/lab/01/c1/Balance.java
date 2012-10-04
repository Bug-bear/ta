public class Balance{
    public static void main(String[] args){
        final double INTEST = 1.05;
        double balance = 1000;
        
        balance = balance * 1.05;
        System.out.print("Balance after first year is ");
        System.out.println(balance); 

        balance = balance * 1.05;
        System.out.print("Balance after second year is "); 
        System.out.println(balance); 

        balance = balance * 1.05;
        System.out.print("Balance after third year is ");
        System.out.println(balance); 
    }
}