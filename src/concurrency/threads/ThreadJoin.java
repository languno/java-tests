package concurrency.threads;

public class ThreadJoin implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println("Hello from a thread.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread was interrupted");
				return;
			}
		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new ThreadJoin());
		
		thread.start();
		
		System.out.println("After thread start");
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread was interrupted");
		}
		
		System.out.println("After thread join");
	}
}
