package geeks.in.action.corejava.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Print numbers up to N such that each threads prints number in circular
 * sequential fashion. T1 prints 1, T2 prints 2, T3 prints 3 and T1 prints 4
 * again. This implementation would allow us to control any number of threads to
 * do sequential ordered execution.
 * 
 * It uses wait() and notifyAll() methods to signal threads
 * 
 * @author manishdevraj
 * 
 */
class SignalThread implements Runnable {
	final AtomicInteger index = new AtomicInteger(1);

	String turn = "1"; // synchronization will take care of visibility

	Map<String, String> sequence = new HashMap<String, String>();

	Object waitNotifySignal;

	public SignalThread(Object waitNotifySignal) {
		this.waitNotifySignal = waitNotifySignal;
	}

	@Override
	public void run() {
		while (index.get() <= 10) {
			synchronized (waitNotifySignal) {
				while (!Thread.currentThread().getName().equalsIgnoreCase(turn)) {
					try {
						waitNotifySignal.wait();
					} catch (InterruptedException e) {
						return;// interrupted means that the thread should stop
					}
				}
			}

			if (index.get() <= 10) {
				System.out.println("Thread: "
						+ Thread.currentThread().getName() + " --- "
						+ index.getAndIncrement());
			}

			synchronized (waitNotifySignal) {
				turn = getNextTurn(turn);
				waitNotifySignal.notifyAll();
			}
		}
	}

	public void setTurnSequence(Map<String, String> sequence) {
		this.sequence = sequence;
	}

	private String getNextTurn(String currentTurn) {
		return sequence.get(currentTurn);
	}

}

public class LinearCircularSignalT {

	public static void main(String[] args) {

		SignalThread signalThread = new SignalThread(new Object());
		Thread t1 = new Thread(signalThread);
		t1.setName("1");
		Thread t2 = new Thread(signalThread);
		t2.setName("2");
		Thread t3 = new Thread(signalThread);
		t3.setName("3");
		Map<String, String> sequence = new HashMap<String, String>();
		sequence.put("1", "2");
		sequence.put("2", "3");
		sequence.put("3", "1");
		signalThread.setTurnSequence(sequence);
		t1.start();
		t2.start();
		t3.start();

	}
}
