package geeks.in.action.corejava.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * This class represents performance factors while considering between ArrayList
 * {@code java.util.ArrayList} and LinkedList {@code java.util.LinkedList}
 * 
 * 1. ArrayList is faster for modifying collection anywhere near end .........
 * 2. LinkedList is faster for modifying collection anywhere near start
 * 
 * @author manishdevraj
 * 
 */
public class ListPerformance {

	/**
	 * Internally represented by array [1, 2, 3, 4 ,5 ... N]
	 */
	private final List<Integer> arrayList = new ArrayList<Integer>();
	/**
	 * Internally represented by linked list [1]->[2]->[3]->[4]->[5] ... [N]
	 */
	private final List<Integer> linkedList = new LinkedList<Integer>();

	public static void main(String[] args) {
		ListPerformance obj = new ListPerformance();
		System.out.println("Adding ArrayList ");
		obj.manipulateList(obj.getArrayList());
		System.out.println("Adding LinkedList ");
		obj.manipulateList(obj.getLinkedList());
		System.out.println("-------------------");
		System.out.println("Appending at start ArrayList ");
		obj.appendList(obj.getArrayList());
		System.out.println("Apending at start LinkedList ");
		obj.appendList(obj.getLinkedList());
		System.out.println("-------------------");
		System.out.println("Appending in end ArrayList ");
		obj.appendListAtEnd(obj.getArrayList());
		System.out.println("Apending in end LinkedList ");
		obj.appendListAtEnd(obj.getLinkedList());
	}

	/**
	 * Manipulate List at the start
	 * 
	 * @param list
	 */
	private void appendList(List<Integer> list) {
		long start = System.currentTimeMillis();
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			int randomInt = r.nextInt(100);
			list.add(randomInt, new Integer(i));
		}
		long end = System.currentTimeMillis();
		System.out.println("Time taken " + (end - start) + " mili secs");
	}

	/**
	 * Manipulate List at the end
	 * 
	 * @param list
	 */
	private void appendListAtEnd(List<Integer> list) {
		long start = System.currentTimeMillis();
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			int randomInt = r.nextInt(100);
			list.add(list.size() - randomInt, new Integer(i));
		}
		long end = System.currentTimeMillis();
		System.out.println("Time taken " + (end - start) + " mili secs");
	}

	/**
	 * Populate first list
	 * 
	 * @param list
	 */
	private void manipulateList(List<Integer> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			list.add(new Integer(i));
		}
		long end = System.currentTimeMillis();
		System.out.println("Time taken " + (end - start) + " mili secs");
	}

	public List<Integer> getArrayList() {
		return arrayList;
	}

	public List<Integer> getLinkedList() {
		return linkedList;
	}
}
