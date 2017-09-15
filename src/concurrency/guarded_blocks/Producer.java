package concurrency.guarded_blocks;

import java.util.Random;

public class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
       
    	int count = 5_000;
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            drop.put(String.valueOf(i));
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {}
        }
        drop.put("DONE");
    }
}