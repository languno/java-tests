package concurrency.guarded_blocks;

import java.util.Random;

public class Consumer implements Runnable {
    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        int count = 0;
        
        while (true) {
        	String message = drop.take();
        	if (message.equals("DONE"))
        		return;
        	
        	int i = 0;
        	
        	try {
        		i = Integer.parseInt(message);
        	} catch (NumberFormatException nfe) {
        	}
        	
        	if (count++ != i) {
        		System.out.println("Consumer: ERROR on counting");
        		return;
        	}
        	
        	if (count % 1_000 == 0) {
        		System.out.println("Couning... " + count);
        	}
        	
        	try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
            	return;
            }
        }
    }
}