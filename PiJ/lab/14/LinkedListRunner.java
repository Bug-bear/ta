import java.util.*;

public class LinkedListRunner{
	public static void main(String[] args){
		List<String> list = new LinkedList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
		list.add("fff");
		list.add("ggg");
		list.add("hhh");
		list.add("iii");
		
		LinkedListRunner runner = new LinkedListRunner();
		ListIterator<String> iterator = (ListIterator)list.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		while(iterator.hasPrevious()){
			//System.out.println(iterator.previous());
			String current = iterator.previous();
			if(current.charAt(0) == 'a' 
				|| current.charAt(0) == 'e'
				|| current.charAt(0) == 'i'
				|| current.charAt(0) == 'o'
				|| current.charAt(0) == 'u'){
					iterator.remove();
			}
		}
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}