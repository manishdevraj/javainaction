package geeks.in.action.java.collections.list;

/**
 * Implement an algorithm to find the nth to last element of a singly linked
 * list.
 * 
 * @author manishdevraj
 * 
 */
public class SearchFromLastNode {

	/**
	 * Assumption: The minimum number of nodes in list is n. Algorithm: 1.
	 * Create two pointers, p1 and p2, that point to the beginning of the node.
	 * 2. Increment p2 by n-1 positions, to make it point to the nth node from
	 * the beginning (to make the distance of n between p1 and p2). 3. Check for
	 * p2->next == null if yes return value of p1, otherwise increment p1 and
	 * p2. If next of p2 is null it means p1 points to the nth node from the
	 * last as the distance between the two is n. 4. Repeat Step 3.
	 */

	public Node<Integer> findNFromLast(final Node<Integer> head, int n) {
		if (head == null || n < 1)
			return null;

		Node<Integer> p1 = head;
		Node<Integer> p2 = head;

		for (int j = 0; j < n - 1; j++) {
			if (p2 == null) {
				return null;
			}
			p2 = p2.next;
		}

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}
}
