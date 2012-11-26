import java.util.*;

public class UserInput{
	public void calculate(){
		double sum = 0;
		System.out.println("how many?");
		String str = System.console().readLine();
		int ctr = Integer.parseInt(str);
		for(int i=0; i<ctr; i++){
			System.out.println("give me a number, got " + i + " so far.");
			str = System.console().readLine();
			try{
				double num = Double.parseDouble(str);
				sum += num;
			} catch (NumberFormatException e){
				System.out.println("Not a number, try again");
				i--;
			}
		}
		System.out.println("average of " + ctr + " numbers is " + (sum/ctr));
	}
	
	public void calculate(int ctr){
		double sum = 0;
		for(int i=0; i<ctr; i++){
			System.out.println("give me a number, got " + i + " so far.");
			String str = System.console().readLine();
			try{
				double num = Double.parseDouble(str);
				sum += num;
			} catch (NumberFormatException e){
				i--;
				System.out.println("Not a number, try again");
			}
		}
		System.out.println("average of " + ctr + " numbers is " + (sum/ctr));
	}	
	
	public int setNumber(){
		System.out.println("how many?");
		String str = System.console().readLine();
		try{
			return Integer.parseInt(str);
		} catch (NumberFormatException e){
			System.out.println("Not a number, try again");
			return setNumber();
		}
	}
	
	public static void main(String[] args){
		UserInput ui = new UserInput();
		//ui.calculate();
		ui.calculate(ui.setNumber());
	}
}