public class Sorters{
	public static void quickSort(int arr[], int left, int right) {
      int i = left, j = right;
      int tmp;
      int pivot = arr[(left + right) / 2];
 
      /* partition */
      while (i <= j) {
            while (arr[i] < pivot)
                  i++;
            while (arr[j] > pivot)
                  j--;
            if (i <= j) {
                  tmp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = tmp;
                  i++;
                  j--;
            }
      };
 
      /* recursion 
		i: the leftmost element larger than pivot
		j: the rightmost element smaller than pivot
	  */
      if (left < j) //more than 1 in the "less"
            quickSort(arr, left, j);
      if (i < right) //more than 1 in the "larger"
            quickSort(arr, i, right);
	}
	
	
	// Test the sorters
	public static void main(String[] args){
		int[] unsorted = {2,4,1,5,3};
		quickSort(unsorted, 0, unsorted.length - 1);
		
		for(int i=0; i<unsorted.length; i++){
			System.out.print(unsorted[i] + " ");
		}
	}
}