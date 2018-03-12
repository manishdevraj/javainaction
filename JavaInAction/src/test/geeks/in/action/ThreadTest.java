package geeks.in.action;

import geeks.in.action.java.thread.ProduceConsumerLowLevel;

import org.junit.Test;

public class ThreadTest extends BaseTestCase {

	@Test
	public void producerConsumerLowLevel() throws InterruptedException {
		final ProduceConsumerLowLevel produceConsumer = new ProduceConsumerLowLevel();
		Thread producer = new Thread() {
			@Override
			public void run() {
				try {
					produceConsumer.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread consumer = new Thread() {
			@Override
			public void run() {
				try {
					produceConsumer.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		producer.start();
		consumer.start();

		producer.join();
		consumer.join();

	}
}
