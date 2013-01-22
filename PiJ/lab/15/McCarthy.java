public class McCarthy{
	public int mcCarthy91(int n) {
		if (n > 100) {
			return n - 10;
		} else {
			return mcCarthy91(mcCarthy91(n+11));
		}
	}
	
	public static void main(String[] args){
		McCarthy mc = new McCarthy();
		if(args.length != 0){
			int n = Integer.parseInt(args[0]);
			System.out.println(mc.mcCarthy91(n));
		}
	}
}