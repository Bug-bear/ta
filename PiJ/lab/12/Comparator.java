public class Comparator {
	public int getMax(int n, int m) {
		if (n > m) {
			return n;
		} else {
			return m;
		}
	}
	/*
	public double getMax(double d1, double d2) {
		if (d1 > d2) {
			return d1;
		} else {
			return d2;
		}
	}
	
	public String getMax(String number1, String number2) {
		int n1 = Integer.parseInt(number1);
		int n2 = Integer.parseInt(number2);
		if (n1 > n2) {
			return number1;
		} else {
			return number2;
		}
	}
	*/
	
	public <T> T getMax(T number1, T number2){
		String num1 = number1.toString();
		String num2 = number2.toString();
		double n1 = Double.parseDouble(num1);
		double n2 = Double.parseDouble(num2);
		if(n1>n2)	return number1;
		else		return number2;
	}
	
	public static void main(String[] args){
		Comparator comp = new Comparator();
		System.out.println(comp.getMax(2.2, 3.3));
		System.out.println(comp.getMax("2", "3"));
	}
}