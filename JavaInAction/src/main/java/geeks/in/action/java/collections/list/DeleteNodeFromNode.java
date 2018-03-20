package geeks.in.action.java.collections.list;

/**
 * Implement an algorithm to delete a node in the middle of a single linked
 * list, given only access to that node. EXAMPLE Input: the node ‘c’ from the
 * linked list a->b->c->d->e Result: nothing is returned, but the new linked
 * list looks like a->b->d->e
 * 
 * @author manishdevraj
 * 
 */
public class DeleteNodeFromNode {

	/**
	 * The solution to this is to simply copy the data from the next node into
	 * this node and then delete the next node.
	 * 
	 * This problem can not be solved if the node to be deleted is the last node
	 * in the linked list.
	 * 
	 * @param n
	 * @return
	 */
	public boolean deleteByNode(Node<Integer> n) {
		if (n == null || n.next == null) {
			return false; // Failure
		}

		Node<Integer> next = n.next;
		n.data = next.data;
		n.next = next.next;

		return true;
	}
}
