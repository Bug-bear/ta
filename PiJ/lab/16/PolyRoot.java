import java.util.*;

public class PolyRoot{
	static final double PRECISION = 0.000001;
	static final double LOW = -1000;
	static final double HIGH = 1000;
	
	public static List<Double> eval(int[] poly){
		return eval(poly, LOW, HIGH);
	}
	
	private static List<Double> eval(int[] poly, double low, double high){
		List<Double> ret = new ArrayList<Double>();
		if(testRoot(testVal(poly, low))){
			ret.add(low);
		}
		if(testRoot(testVal(poly, high))){
			ret.add(high);
		}
		//if(low<high && ret.size()<=(poly.length-1) ((testVal(poly,low)*testVal(poly,high))<0 || ret.size()<=poly.length-1)){
		// add bits here according to requirements
		return ret;
	}
	
	public static double testVal(int[] poly, double x){
		double result = 0;
		for(int i=0; i<poly.length; i++){
			result += poly[i] * Math.pow(x, i);
		}
		return result;
	}
	
	public static boolean testRoot(double x){
		return Math.abs(x) < PRECISION;
	}
	
	public static void main(String[] args){
		int[] poly1 = {6, -5, 1};
		//System.out.println(testRoot(poly, 3));
		System.out.println(eval(poly1));
		int[] poly2 = {-9, -6, 3};
		System.out.println(eval(poly2));
	}
}