package geeks.in.action.corejava.thread;

import java.util.HashMap;
import java.util.Map;

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
	volatile Integer i = 1;

	volatile String turn = "1";

	Map<String, String> sequence = new HashMap<String, String>();

	WaitNotifySignal waitNotifySignal;

	public SignalThread(WaitNotifySignal waitNotifySignal) {
		this.waitNotifySignal = waitNotifySignal;
	}

	@Override
	public void run() {
		while (i.intValue() <= 10) {
			if (Thread.currentThread().getName().equalsIgnoreCase(turn)) {
				System.out.println("Thread: "
						+ Thread.currentThread().getName() + " --- " + i);
				i++;
				turn = getNextTurn(turn);
				waitNotifySignal.doNotifyAll();
				waitNotifySignal.doWait();
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

/**
 * Common Wait Notify Signal class
 * 
 * @author manishdevraj
 * 
 */
class WaitNotifySignal {

	Object monitorObject = new Object();

	boolean wasSignalled = false;

	public void doWait() {
		synchronized (monitorObject) {
			while (!wasSignalled) {
				try {
					monitorObject.wait();
				} catch (InterruptedException e) {
				}
			}
			// clear signal and continue running.
			wasSignalled = false;
		}
	}

	public void doNotifyAll() {
		synchronized (monitorObject) {
			wasSignalled = true;
			monitorObject.notify();
		}
	}
}

public class LinearCircularSignalT {

	public static void main(String[] args) {

		SignalThread signalThread = new SignalThread(new WaitNotifySignal());
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
