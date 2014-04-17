package org.edu.stiffy.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Simple Fixed Thread Pool example using {@link ExecutorService}. Code has been
 * extended to use {@link CountDownLatch} that manages number of parallel thread
 * allowed to be executed Like in below example only 2 threads are allowed to be
 * executed though 5 tasks have been allotted.
 * 
 * @author manishdevraj
 * 
 */
public class ExecutorThreadPool {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			executor.submit(new Processor(i, latch));
		}
		executor.shutdown();
		System.out.println("All tasks submitted.");
		try {
			executor.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
		}
		System.out.println("All tasks completed.");
	}
}

class Processor implements Runnable {
	private final int id;
	private final CountDownLatch latch;

	public Processor(int id, CountDownLatch latch) {
		this.id = id;
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Starting : " + id);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		System.out.println("Completed : " + id);
		latch.countDown();
	}
}
