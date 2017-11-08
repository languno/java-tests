package concurrency.utils;

import java.util.concurrent.*;
import java.util.stream.*;

public class CyclicBarrierTest {

	public static void await(CyclicBarrier cb) {
		try {
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			System.out.println("Barrier interrupted or broken");
		}
	}
	
	public static void main(String[] args) {
		final CyclicBarrier cb = new CyclicBarrier(3, () -> System.out.println("Barrier reached"));
	}
	
}
