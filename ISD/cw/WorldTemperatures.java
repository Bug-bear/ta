import java.util.*;

public class WorldTemperatures {
	public static void main (String[] arguments) {
		String[] cities = { "Sydney", "Cape Town", "Paris", "Bangalore",
		"Santiago", "New York", "Cairo", "Moscow",
		"Athens", "Copenhagen" };
		int[] minTemps = { 6, 8, -1, 12, 2, -5, 4, -10, -2, -8 };
		int[] maxTemps = { 33, 34, 29, 39, 32, 37, 42, 32, 39, 34};
		System.out.println("Original stats : ");
		for(int i=0; i<minTemps.length; i++){
			System.out.println(cities[i] + " : " + (maxTemps[i] - minTemps[i]));
		}
		
		System.out.println("\nResults : ");
		ArrayList<Integer> result = findCity(minTemps, maxTemps);
		for(Integer element : result){
			System.out.println(cities[element] + " : " + (maxTemps[element] - minTemps[element]));
		}
	}
	
	public static ArrayList<Integer> findCity(int[] mins, int[] maxs){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int varMax = 0;
		
		for(int i=0; i<mins.length; i++){
			int varTemp = maxs[i] - mins[i];
			if(varMax < varTemp){
				varMax = varTemp;
				ret.clear();
				ret.add(i);
			}
			else if(varMax == varTemp){
				ret.add(i);
			}
			else{
				continue;
			}
		}
		return ret;
	}
}