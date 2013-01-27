public class Classics{
	private static int[] precalculated = null;

	//Factorial
	public static int factorial(int n) {
		if(n == 0){
			return 1;
		}
		return n*factorial(n-1);
	}
	
	//Fibonacci
	public static int fib(int n) {
		if (precalculated == null) {
			initPrecalculatedArray(n);
		}
		if (precalculated[n-1] != -1) {
			return precalculated[n-1];
		} else {
			int result = fib(n-1) + fib(n-2);
			precalculated[n-1] = result;
			return result;
		}
	}
	private static void initPrecalculatedArray(int size) {
		precalculated = new int[size];
		for (int i = 0; i < precalculated.length; i++) {
			precalculated[i] = -1; // to indicate "not calculated yet"
		}
		precalculated[0] = 1; // F(1)
		precalculated[1] = 1; // F(2)
	}
	
	//hanoi tower
	public static int hanoi(int n){
		return hanoi_internal("src", "dst", "spare", n);
	}
	public static int hanoi_internal(String start_pos, String end_pos, String spare_pos, int n){  
		if (n > 0){  
			/*
			hanoi_internal(start_pos, spare_pos, end_pos, n-1, ctr);
			System.out.println("Move disc from " + start_pos + " to " + end_pos);
			hanoi_internal(spare_pos, end_pos, start_pos, n-1, ctr);
			*/
			return 1 + hanoi_internal(start_pos, spare_pos, end_pos, n-1) + hanoi_internal(spare_pos, end_pos, start_pos, n-1);
		}
		else return 0;
	}

	
	public static void main(String[] args){
		if(args.length != 0){
			int n = Integer.parseInt(args[0]);
			
			//System.out.println(factorial(n));
			//System.out.println(fib(n));
			System.out.println(hanoi(n));
		}
	}
}