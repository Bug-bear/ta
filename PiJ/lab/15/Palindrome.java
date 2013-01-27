public class Palindrome{
	public static boolean palindrom(String str){
		if(str.length() > 1){
			return (str.charAt(0) == str.charAt(str.length()-1)) && palindrom(str.substring(1,str.length()-1));
		}
		else{
			return true;
		}
	}

	public static void main(String[] args){
		if(args.length != 0){
			System.out.println(palindrom(args[0]));
		}
	}
}