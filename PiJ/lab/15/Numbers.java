public class Numbers{
	public static void main(String[] args){
		printNumbers(6);
	}

	public static void printNumbers(int n) {
		if (n <= 0) {
			return;
		}
		System.out.println(n);
		printNumbers(n-2);
		printNumbers(n-3);
		System.out.println(n);
	}

}