package org.edu.stiffy.corejava.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Different Synchronized methods of same object cannot be called
 * simultaneously. Having synchronized block on "this" has similar effect as
 * above. We need to create different objects(locks) to be able to achieve this.
 * 
 * @author manishdevraj
 * 
 */
public class WorkerMultiLock {
	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.main();
	}
}

class Worker {

	private final List<Integer> list1 = new ArrayList<Integer>();
	private final List<Integer> list2 = new ArrayList<Integer>();

	private final Random random = new Random();
	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	public void main() {

		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				processList();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				processList();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("Time taken :" + (end - start) / 1000 + " secs...");
		System.out.println("List1 :" + list1.size() + "; List2 :"
				+ list2.size());

	}

	public void processList() {
		for (int i = 0; i < 1000; i++) {
			manipulateList1();
			manipulateList2();
		}

	}

	public void manipulateList1() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}

	}

	public void manipulateList2() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list2.add(random.nextInt(100));
		}

	}
}
