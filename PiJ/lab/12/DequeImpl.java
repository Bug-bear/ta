public class DequeImpl implements Deque{
	public Dnode<?> head;
	public Dnode<?> tail;
	
	public DequeImpl(){
		head = null;
	}
	
	public void append(Dnode d){
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