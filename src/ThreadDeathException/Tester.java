package ThreadDeathException;

public class Tester {
	public static void main(String[] args) {
		new Tester();
	}
	
	public Tester() {
		LoopingRunner lr = new LoopingRunner();
		Thread t = new Thread(lr);
		System.out.println("Start the looping runner...");
		t.start();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t.stop();
		System.out.println("finally the thread died");
	}
}
