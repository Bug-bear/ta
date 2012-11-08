public class SortedDequeImpl<T extends Comparable> implements Deque{
	public Dnode<T> head;
	public Dnode<T> tail;
	
	public SortedDequeImpl(){
		head = null;
	}
	
	public void append(Dnode d){
		if(head == null){
			head = d;
			tail = d;
		}
		else{
			Dnode temp = head;
			while(d.value.compareTo(temp.value)>0){
				System.out.println("yeah");
				return;
			}
		}
	}
	
	public Dnode popFront(){
		Dnode temp = head;
		if(temp == null){
			return null;
		}
		else{
			if(temp.right != null){
				temp.right.left = null;
			}
			head = temp.right;
			//System.out.println(temp.value);
			return temp;
		}
	}
}