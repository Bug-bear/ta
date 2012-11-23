import java.util.ArrayList;
import java.util.List;

public class MyList {

	private List<Integer> list;
	
	public boolean contains (int elt) {
		return true;
	}
	
	public static void main(String[] args) {
		MyList myList = new MyList();
		myList.launch();
		
		List<Integer> wawa = new ArrayList<Integer>();
		for(int i=0; i<9; i++){
			wawa.add(i);
		}
		System.out.println(wawa);
		List<Integer> yaya = wawa.subList(1,5);
		System.out.println(yaya);
		yaya.remove(2);
		System.out.println(yaya);
		System.out.println(wawa);
	}
	
	public void launch() {
		list = new ArrayList<Integer>();
		populateList(5);
		printList();
		System.out.println("***");
		list = mergeSort(list);
		printList();
	}
	
	public void populateList() {
		populateList(20);
	}
	
	public void populateList(int length) {
		for (int i = 0; i<length; i++) {
			list.add((int)Math.abs(100*Math.random()));
		}
	}
	
	public void printList() {
		for (int i = 0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public List<Integer> mergeSort(List<Integer> list) {
		if (list.size()<2) {
			System.out.println("wa");
			return list;
		} else 
		{
			System.out.println("pre-left");
			List<Integer> left = new ArrayList<Integer>(list.subList(0, list.size()/2));
			System.out.println(left);
			System.out.println("pre-right");
			List<Integer> right = new ArrayList<Integer>(list.subList(list.size()/2, list.size()));
			System.out.println(right);
			left = mergeSort(left);
			right = mergeSort(right);
			List<Integer> result = new ArrayList<Integer>();
			while (!left.isEmpty()&& !right.isEmpty()) {
				if (left.get(0)<right.get(0)) {
					result.add(left.get(0));
					left.remove(0);
				} else {
					result.add(right.get(0));
					right.remove(0);
				}
			}
			//result.addAll(left);
			//result.addAll(right);
			return result;
		}
	}
}
	