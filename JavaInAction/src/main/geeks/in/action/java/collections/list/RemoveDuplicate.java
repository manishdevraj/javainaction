package geeks.in.action.java.collections.list;

import java.util.Hashtable;

/**
 * Write code to remove duplicates from an unsorted linked list. FOLLOW UP How
 * would you solve this problem if a temporary buffer is not allowed?
 * 
 * @author manishdevraj
 * 
 */
public class RemoveDuplicate {

	/**
	 * If we can use a buffer, we can keep track of elements in a Hashtable and
	 * remove any duplicates:
	 * 
	 * @param n
	 * @return
	 */
	public Node<String> remoeDuplicateWithBuffer(final Node<String> n) {
		Hashtable<String, Boolean> table = new Hashtable<String, Boolean>();
		Node<String> node = n;
		if (node == null)
			return node;

		Node<String> prev = null;
		while (node.next != null) {
			if (table.containsKey(node.data)) {
				prev.next = node.next;
			} else {
				table.put(node.data, true);
				prev = node;
			}
			node = node.next;
		}
		return node;
	}

	/**
	 * Without a buffer, we can iterate with two pointers: “current” does a
	 * normal iteration, while “runner” iterates through all prior nodes to
	 * check for dups. Runner will only see one dup per node, because if there
	 * were multiple duplicates they would have been removed already.
	 * 
	 * @param n
	 * @return
	 */
	public Node<String> remoeDuplicateWithoutBuffer(final Node<String> head) {
		if (head == null)
			return head;

		Node<String> prev = head;
		Node<String> current = prev.next;

		while (current != null) {
			Node<String> runner = head;
			while (runner != current) { // check for earlier duplicates
				if (current.data != null && current.data.equals(runner.data)) {
					Node<String> temp = current.next;
					prev.next = temp;
					current = temp;
					break; // all other are removed here
				}
				runner = runner.next;
			}

			if (current.equals(runner)) {
				prev = current;
				current = current.next;

			}
		}
		return head;
	}
}
