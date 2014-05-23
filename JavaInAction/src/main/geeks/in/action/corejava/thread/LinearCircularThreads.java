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
 * It uses Thread.sleep to idle threads without using explicit signaling
 * 
 * @author manishdevraj
 * 
 */
class SeqThread implements Runnable {
	final AtomicInteger index = new AtomicInteger(1);
	volatile String turn = "1";
	Map<String, String> sequence = new HashMap<String, String>();

	@Override
	public void run() {
		while (index.get() <= 10) {
			if (Thread.currentThread().getName().equalsIgnoreCase(turn)) {
				System.out.println("Thread: "
						+ Thread.currentThread().getName() + " --- "
						+ index.getAndIncrement());
				turn = getNextTurn(turn);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
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

public class LinearCircularThreads {

	public static void main(String[] args) {

		SeqThread seqThread = new SeqThread();
		Thread t1 = new Thread(seqThread);
		t1.setName("1");
		Thread t2 = new Thread(seqThread);
		t2.setName("2");
		Thread t3 = new Thread(seqThread);
		t3.setName("3");
		Map<String, String> sequence = new HashMap<String, String>();
		sequence.put("1", "2");
		sequence.put("2", "3");
		sequence.put("3", "1");
		seqThread.setTurnSequence(sequence);
		t1.start();
		t2.start();
		t3.start();
	}
}
