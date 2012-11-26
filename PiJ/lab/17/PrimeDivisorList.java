import java.util.*;

public class PrimeDivisorList{
	private List<Integer> list = new ArrayList<Integer>();
	
	public void add(Integer num){
		if(num == null){
			throw new NullPointerException();
		}
		if(!isPrime(num)){
			throw new IllegalArgumentException(num + " is not a prime number");
		}
		list.add(num);
	}
	
	//checks whether an int is prime or not.
	boolean isPrime(int n) {
		if(n == 2) return true;
		//check if n is a multiple of 2
		if (n%2==0) return false;
		//if not, then just check the odds
		for(int i=3;i*i<=n;i+=2) {
			if(n%i==0)
				return false;
		}
		return true;
	}	
	
	public String toString(){
		list = mergeSort(list);
		int result = 1;
		String ret = "[ ";
		int pow = 1;
		int pos = 0;
		int last = list.get(0);
		while(pos < list.size()){
			ret += list.get(pos);
			result *= list.get(pos);
			int i=0;
			for(i=pos; (i < list.size()-1)&&(list.get(i) == list.get(i+1)); i++){
				pow++;
				result *= list.get(i);
			}
			pos = ++i;
			System.out.println(pos);
			if(pow > 1){
				ret += "^"+pow;
			}
			ret += " * ";
			pow = 1;
		}
		ret = ret.substring(0, ret.length()-2) + "= " + result + " ]";
		return ret;
	}
	
	private List<Integer> mergeSort(List<Integer> data){
		if(data.size() <= 1){
			return data;
		}
		//recursion
		int mid = (data.size()-1)/2; // this line correspond to where middle goes
		//System.out.println("left " + data.subList(0, mid+1));
		List<Integer> left = mergeSort(data.subList(0, mid+1));
		//System.out.println("right " + data.subList(mid+1, data.size()));
		List<Integer> right = mergeSort(data.subList(mid+1, data.size()));
		//integration
		List<Integer> ret = new ArrayList<Integer>();
		int l = 0, r = 0;
		while(l<left.size() && r<right.size()){
			if(left.get(l) > right.get(r)){
				ret.add(right.get(r));
				r++;
			} else{
				ret.add(left.get(l));
				l++;
			}
		}
		while(l < left.size()){
			ret.add(left.get(l));
			l++;
		}
		while(r < right.size()){
			ret.add(right.get(r));
			r++;
		}
		return ret;
	}	
}