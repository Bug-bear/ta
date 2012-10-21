public class MyMap implements SimpleMap {
	class Entry{
		private int k;
		private String n;
		private Entry next;
		
		public Entry(int key, String name){
			this.k = key;
			this.n = name;
			this.next = null;
		}
	}
	
	private Entry head;
	
	public MyMap(){
		this.head = null;
	}
	
	public String put(int key, String name){
		if(this.head == null){
			head = new Entry(key, name);
		} else{
			Entry last, h = head;
			do{
				if(h.k == key){
					System.out.println("Already in the map - nothing done");
					return null;
				}
				last = h;
				h = h.next;
			}
			while(h != null);
			//reach this point if there's no previous record of the same key
			last.next = new Entry(key, name);
		}
		return name;
	}
	
	public String get(int key){
		Entry h  = head;
		while(h != null){
			if(h.k == key){
				return h.n;
			}
			h = h.next;
		}
		return null;
	}
	
	public void remove(int key){
		if(head == null){
			System.out.println("Can't remove from an empty map");
			return;
		}
		if(head.k == key){
			head = head.next;
		} else{
			Entry h  = head;
			while(h != null){
				if(h.next.k == key){
					h.next = h.next.next;
					return;
				}
				h = h.next;
			}
		}
	}
	
	public boolean isEmpty(){
		return (head == null);
	}
	
	
	//my helper
	public void checkMap(){
		Entry e = head;
		System.out.println("There are :");
		while(e != null){
			System.out.print(" " + e.k + "," + e.n + " ");
			e = e.next;
		}
		System.out.println();		
	}
	
	public static void main(String[] args){
		MyMap map = new MyMap();
		for(int i=1; i<10; i++){
			System.out.println(map.put(i, "record "+i) + " added ");
		}
		map.checkMap();
		map.put(3, ":P");
		map.checkMap();
		
		System.out.println(map.get(1));
		System.out.println(map.get(9));
		
		map.remove(1);
		map.checkMap();
		System.out.println(map.get(1));
		
		map.remove(9);
		map.checkMap();
		System.out.println(map.get(9));
		
		map.put(1, ":P");
		map.checkMap();
		System.out.println(map.get(1));
	}
}