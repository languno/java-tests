package concurrency.threads;

public class ThreadSleep {
	public static void main(String[] args) throws InterruptedException {
		
		int count = 0;
		
		for (int i = 0; i < 4; i++) {
			System.out.println("I am counting... " + ++count);
			Thread.sleep(1000);
		}
	}
}
