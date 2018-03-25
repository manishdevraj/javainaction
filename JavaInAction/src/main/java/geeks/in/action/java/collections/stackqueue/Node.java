package geeks.in.action.java.collections.stackqueue;

/**
 * 
 * @author manishdevraj
 * 
 * @param <T>
 */
public class Node<T> {
	public Node<T> next;
	public T data;

	public Node(T data) {
		this.data = data;
	}

	public void appendToTail(final T data) {
		Node<T> end = new Node<T>(data);
		Node<T> n = this;

		while (n.next != null) {
			n = n.next;
		}

		n.next = end;
	}

	@Override
	public String toString() {
		return "Node{" +
				"next=" + next +
				", data=" + data +
				'}';
	}
}
