import java.util.*;

public class UI{
	List<String> tds = new ArrayList<String>();
	public static void main(String args[]) {
		UI ui = new UI();
		Scanner in = new Scanner(System.in);
		for(int i=0; i<3; i++){
			synchronized(ui){
				System.out.println("duration?");
				int len = in.nextInt();
				System.out.println("duration?");
				int len = in.nextInt();
			}
			Task task = new Task(i, len, this);
			Thread t = new Thread(task);
			t.start();
		}
		Sytem.out.println(tds);
	}
	
	public void inform(int id){
		this.tds.add(id);
	}
}

class Task implements Runnable{
	private int ID;
	private int LENGTH;
	private boolean toReg;
	private UI ui;
	
	public Task(int id, int len, UI ui){
		this.ID = id;
		this.LENGTH = len;
		this.toReg = false;
		this.ui = ui;
	}
	
	public void run(){
		waiting();
	}
	
	public void waiting(){
		synchronized(this.ui){
			try {
				//Thread.sleep(LENGTH); // sleep 1 second
				wait(LENGTH);
				toReg = true;
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		
			temp.inform(ID);
		}
	}
}