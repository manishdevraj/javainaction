package geeks.in.action.java.thread;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Classic Producer Consumer problem solved using Blocking Queue
 * 
 * @author manishdevraj
 * 
 */
class Producer implements Runnable {
	private final Random random = new Random();

	@Override
	public void run() {
		while (true) {
			try {
				ProducerConsumerBlockQ.sQueue.put(random.nextInt(100));
			} catch (InterruptedException e) {
			}
		}

	}
}

class Consumer implements Runnable {
	private final Random random = new Random();

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(2000);
				if (random.nextInt(10) % 2 == 0) {
					Integer value = ProducerConsumerBlockQ.sQueue.take();
					System.out.println("Taken: " + value + "; Queue size: "
							+ ProducerConsumerBlockQ.sQueue.size());
					Iterator<Integer> iterator = ProducerConsumerBlockQ.sQueue
							.iterator();
					while (iterator.hasNext()) {
						System.out.print(" " + iterator.next());
					}
					System.out.println("");
				}

			} catch (InterruptedException e) {
			}
		}

	}
}

public class ProducerConsumerBlockQ {

	public static BlockingQueue<Integer> sQueue = new ArrayBlockingQueue<Integer>(
			10);

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Producer());
		Thread t2 = new Thread(new Consumer());

		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}

}
