package concurrency.executors;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Demonstrates the use of the Executor interfaces.
 */
public class ExecutorExample {
	public static void main(String[] args) {

		/*
		 * The Executor interface is designed as a simple replacement of the thread-creation idiom:
		 *     (new Thread(runnable)).start();
		 *      e.execute(r);
		 */
		Executor e = Executors.newSingleThreadExecutor();
		e.execute(() -> System.out.println("Hello from a thread."));

		/*
		 * The ExecutorService interface provides more functionality like Futures and stopping of execution.
		 */
		ExecutorService es = Executors.newSingleThreadExecutor();

		Future<Double> future = es.submit(new TestCallable(1_000_000));

		try {
			System.out.println("Result of calculation: " + future.get());
		} catch (InterruptedException | ExecutionException ie) {
			System.out.println("Calculation was interrupted: " + ie.getMessage());
		}

		// Future<Double> longRunningFuture = es.submit(new TestCallable(Integer.MAX_VALUE));
		// System.out.println("Shutdown long running task ...");
		// es.shutdown()        // not accepting more tasks, but let active ones finish
		// es.shutdownNow()     // try to terminate tasks by calling Thread.interrupt()

		/*
		 * The ScheduledExecutor interface allows to execute tasks periodically.
		 */
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		scheduler.scheduleAtFixedRate(() -> System.out.println("Scheduled hello"), 0, 1, SECONDS);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException ie) {}

		scheduler.shutdown();
	}

	static class TestCallable implements Callable<Double> {
		private int max;

		public TestCallable(int max) {
			this.max = max;
		}

		@Override
		public Double call() {
			double k = 1.0;
			// some long running operation ...
			for (int i = 0; i < max; i++)
				k = k * 2 % 1e8;
			return k;
		}
	}
}
