import java.util.concurrent.atomic.AtomicInteger;
 
 public class TestAtom{
	static class SynchronizedCounter {
		private AtomicInteger c = new AtomicInteger(0);

		public void increment() {
			c.incrementAndGet();
		}

		public void decrement() {
			c.decrementAndGet();
		}

		public int value() {
			return c.get();
		}
	}
	
	public static void main(String[] args){
		final SynchronizedCounter testee = new SynchronizedCounter();
		new Thread(new Runnable(){
			public void run(){ 
				for(int i=0; i<3; i++){
					synchronized(testee){
						testee.increment();
						System.out.println("a" + testee.value());
					}
				}
			}
		}).start();
		
		new Thread(new Runnable(){
			public void run(){ 
				for(int i=0; i<3; i++){		
					synchronized(testee){
						testee.decrement();
						System.out.println("b" + testee.value());
					}
				}
			}
		}).start();
	}
}
