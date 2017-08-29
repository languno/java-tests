package ThreadDeathException;

public class LoopingRunner implements Runnable {

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("Loop");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (ThreadDeath td) {
			System.out.println("LoopingRunner: I've been the victim of an ThreadDeath!");
		}
	}
}
