import java.util.ArrayList;

public class MyMap2 implements SimpleMap2 {
	class Entry2{
		private int k;
		private ArrayList<String> n;
		private Entry2 next;
		
		public Entry2(int key, String name){
			this.k = key;
			this.n = new ArrayList<String>();
			this.n.add(name);
			this.next = null;
		}
		
		public void updateEntry(String name){
			this.n.add(name);
		}
		
		public String[] readEntry(){
			return (String[]) this.n.toArray((new String[this.n.size()]));
		}
	}
	
	private Entry2 head;
	
	public MyMap2(){
		this.head = null;
	}
	
	public String put(int key, String name){
		if(this.head == null){
			head = new Entry2(key, name);
		} else{
			Entry2 last, h = head;
			do{
				if(h.k == key){
					System.out.println("Key already in the map - update");
					h.updateEntry(name);
					return name;
				}
				last = h;
				h = h.next;
			}
			while(h != null);
			//reach this point if there's no previous record of the same key
			System.out.println("adding new tuple");
			last.next = new Entry2(key, name);
		}
		return name;
	}
	
	public String[] get(int key){
		Entry2 h  = head;
		while(h != null){
			if(h.k == key){
				return h.readEntry();
			}
			h = h.next;
		}
		return null;
	}
	
	public void remove(int key, String name){
		if(head == null){
			System.out.println("Can't remove from an empty map");
			return;
		}
		if(head.k == key){
			head.n.remove(name);
			System.out.println("removing name "+name);
			if(head.n.size() == 0){
				System.out.println("entry with key "+key+" now empty - removed");
				head = head.next;
			}
		} else{
			Entry2 h  = head;
			while(h != null){
				if(h.next.k == key){
					System.out.println("removing name "+name);
					h.next.n.remove(name);
					if(h.next.n.size() == 0){
						System.out.println("entry with key "+key+" now empty - removed");
						h.next = h.next.next;
					}
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
		Entry2 e = head;
		System.out.println("There are :");
		while(e != null){
			System.out.print(" " + e.k + "," + e.n + " ");
			e = e.next;
		}
		System.out.println();		
	}
	
	public static void main(String[] args){
		MyMap2 map = new MyMap2();
		for(int i=1; i<10; i++){
			System.out.println(map.put(i, "record "+i) + " added ");
		}
		map.checkMap();
		map.put(3, ":P");
		map.checkMap();
		
		System.out.println();
		String[] temp = map.get(3);
		for(int i=0; i<temp.length; i++){
			System.out.print(temp[i]+" ");
		}
		System.out.println();
		
		map.remove(1, "record 1");
		map.checkMap();
		
		map.remove(3, "record 3");
		map.checkMap();
		
		map.remove(9, "record 9");
		map.checkMap();
		
		/*
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
		*/
	}
}