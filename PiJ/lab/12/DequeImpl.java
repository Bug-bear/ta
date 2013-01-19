public class DequeImpl<T extends Comparable> implements Deque<T>{
	public Dnode<T> head;
	public Dnode<T> tail;
	
	public DequeImpl(){
		head = null;
	}
	
	public void append(Dnode<T> d){
		if(head == null){
			head = d;
			tail = d;
		}
		else{
			tail.right = d;
			d.left = tail;
			tail = d;
		}
	}
	
	public Dnode<T> popFront(){
		Dnode<T> temp = head;
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