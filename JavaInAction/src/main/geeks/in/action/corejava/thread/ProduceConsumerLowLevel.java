package geeks.in.action.corejava.thread;

import java.util.LinkedList;

public class ProduceConsumerLowLevel {

	Object lock = new Object();
	LinkedList<Integer> queue = new LinkedList<Integer>();
	int LIMIT = 10;

	public void produce() throws InterruptedException {
		int data = 0;
		while (true) {
			synchronized (lock) {
				while (queue.size() == LIMIT) {
					lock.wait();
				}
				queue.add(data++);
				lock.notify();
			}
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (lock) {
				while (queue.size() == 0) {
					lock.wait();
				}
				System.out.print("Queue size is :" + queue.size());
				int value = queue.removeFirst();
				System.out.println("; value removed : " + value);
				lock.notify();
			}
			Thread.sleep(1000);
		}
	}

}
