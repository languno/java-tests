package concurrency.threads;

public class LargeNumberOfThreadsTest {

	static class TestThread extends Thread {
		
		private static int count = 0;
		
		public static int getCount() {
			int c;
			
			synchronized (TestThread.class) {
				c = count;
			}
			return c;
		}
		
		@Override
		public void run() {
			int i = 0;
			while (i < 10) {
				i++;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					return;
				}
			}
			
			synchronized (TestThread.class) {
				count++;
			}
			
			System.out.format("Thread %s finished%n", this.getName());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestThread[] threads = new TestThread[5000];
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new TestThread();
		}
	
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		
		System.out.println("TestThread count = " + TestThread.getCount());
	}
}
