public class Increaser implements Runnable {
	private Counter c;
	
	public Increaser(Counter counter) {
		this.c = counter;
	}
	
	public static void main(String args[]) {
		Counter counter = new Counter();
		for (int i = 0; i < 10; i++) {
			Increaser increaserTask = new Increaser(counter);
			Thread t = new Thread(increaserTask);
			t.start();
			/*
			try{
				t.join();
			} catch(InterruptedException e){
				System.out.println(e);
			}
			*/
		}
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getId() + " Starting at " + c.getCount());
		for (int i = 0; i < 10; i++) {
			c.increase();
		}
		System.out.println(Thread.currentThread().getId() + " Stopping at " + c.getCount());
	}
	
}
	
class Counter {
	private int n = 0;
	
	public void increase() {
		n++;
	}
	
	public int getCount() {
		return n;
	}
}