 import java.util.Random;
 
 public class TestInterference{
	static class SynchronizedCounter {
		private volatile int c = 0;

		public  void increment() {
			c++;
			System.out.println("+" + c);
		}

		public  void decrement() {
			c--;
			System.out.println("-" + c);
		}

		public  int value() {
			return c;
		}
	}
	
	public static void main(String[] args){
		final SynchronizedCounter testee = new SynchronizedCounter();
		new Thread(new Runnable(){
			public void run(){ 
				Random random = new Random();
				for(int i=0; i<3; i++){
					testee.increment();
				}
			}
		}).start();
		
		new Thread(new Runnable(){
			public void run(){ 
				Random random = new Random();
				for(int i=0; i<3; i++){		
					testee.decrement();
				}
			}
		}).start();
	}
}
