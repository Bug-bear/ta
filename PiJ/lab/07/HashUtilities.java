public class HashUtilities{
	public static int shortHash(int num){
		num = Math.abs(num);
		return num%1000;
	}
}