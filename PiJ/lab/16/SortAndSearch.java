import java.util.*;

public class SortAndSearch{
	public static boolean binarySearch(List<Integer> data, int num){
		if(data.size() == 0){
			return false;
		}
		else{
			return bSearch(data, num, 0, data.size()-1);
		}
	}
	
	private static boolean bSearch(List<Integer> data, int num, int start, int end){
		if(start <= end){
			int mid = (end+start)/2;
			if(data.get(mid) == num){
				return true;
			}
			if(data.get(mid) > num){
				//System.out.println("left " + mid + " " + data.get(mid));
				return bSearch(data, num, start, mid-1);
			}
			else if(data.get(mid) < num){
				//System.out.println("right " + mid + " " + data.get(mid));
				return bSearch(data, num, mid+1, end);
			}
		}
		return false;	
	}
	
	public static void quickSortArray(int arr[], int left, int right) {
      int i = left, j = right;
      int tmp;
      int pivot = arr[(left + right) / 2];
 
      /* partition */
      while (i <= j) {
            while (arr[i] < pivot){
                  i++;
			}
            while (arr[j] > pivot){
                  j--;
			}
            if (i <= j) {
                  tmp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = tmp;
                  i++;
                  j--;
            }
      }
 
      /* recursion 
		i: the leftmost element larger than pivot
		j: the rightmost element smaller than pivot
	  */
      if (left < j) //more than 1 in the "less"
            quickSortArray(arr, left, j);
      if (i < right) //more than 1 in the "larger"
            quickSortArray(arr, i, right);
	}
	
	public static List<Integer> quickSortList(List<Integer> data){
		return sortQuick(data, data.get(0));
	}
	
	private static List<Integer> sortQuick(List<Integer> data, int pivot){
		//check for exit case
		if(data.size() <= 1){
			return data;
		}
		//divide
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		
		for(int i=1; i<data.size(); i++){
			if(data.get(i) < pivot){
				left.add(data.get(i));
			} 
			else{
				right.add(data.get(i));
			}
		}
		//recursion
		if(left.size() > 1)
			left = sortQuick(left, left.get(0));
		if(right.size() > 1)
			right = sortQuick(right, right.get(0));			
		//concatenation
		List<Integer> ret = left;
		ret.add(pivot);
		ret.addAll(right);
		
		return ret;
	}
	
	public static List<Integer> mergeSort(List<Integer> data){
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
	
	// Tests
	public static void main(String[] args){
		int[] unsorted = {2,4,1,5,3};
		quickSortArray(unsorted, 0, unsorted.length - 1);
		for(int i=0; i<unsorted.length; i++){
			System.out.print(unsorted[i] + " ");
		}
		System.out.println();
		
		List<Integer> testee = new ArrayList<Integer>();
		for(int i=0; i<10; i++){
			testee.add((int)Math.abs(100 * Math.random()));
		}
		testee.add(60);
		System.out.println(testee);
		List<Integer> sorted1 = quickSortList(testee);
		System.out.println(sorted1);
		System.out.println(binarySearch(sorted1, 60));
		System.out.println();
		
		List<Integer> sorted2 = mergeSort(testee);
		System.out.println(sorted2);
	}
}