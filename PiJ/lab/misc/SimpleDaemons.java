public class SimpleDaemons extends Thread {
  public SimpleDaemons() {
    setDaemon(true); // Must be called before start()
    start();
  }
  public void run() {
    while(true) {
      /*try {
        sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }*/
      System.out.println(this);
    }
  }
  public static void main(String[] args) {
    for(int i = 0; i < 10; i++)
      new SimpleDaemons();
  }
}