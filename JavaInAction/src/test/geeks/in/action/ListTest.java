package geeks.in.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import geeks.in.action.java.collections.list.DeleteNodeFromNode;
import geeks.in.action.java.collections.list.Node;
import geeks.in.action.java.collections.list.RemoveDuplicate;
import geeks.in.action.java.collections.list.SearchFromLastNode;

import org.junit.Test;

public class ListTest extends BaseTestCase {

	@Test
	public void testRemoveDuplicates() {
		Node<String> node = new Node<String>("Manish");
		node.appendToTail("Devraj");
		node.appendToTail("Devraj");
		node.appendToTail("Manish");
		node.appendToTail("Devraj");
		node.appendToTail("Geek");

		System.out.println(node);
		Node<String> testNode = node;

		RemoveDuplicate removeDuplicate = new RemoveDuplicate();

		removeDuplicate.remoeDuplicateWithBuffer(testNode);

		System.out.println("With buffer -> " + testNode);

		removeDuplicate.remoeDuplicateWithoutBuffer(node);

		System.out.println("Without buffer -> " + node);

	}

	@Test
	public void testSearchNFromLast() {
		Node<Integer> node = new Node<Integer>(1);
		node.appendToTail(2);
		node.appendToTail(3);
		node.appendToTail(4);
		node.appendToTail(5);
		node.appendToTail(6);

		System.out.println(node);

		SearchFromLastNode obj = new SearchFromLastNode();
		Node<Integer> result = obj.findNFromLast(node, 3);
		assertEquals(Integer.valueOf(4), result.data);

	}

	@Test
	public void testDeleteByNode() {
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		System.out.println(n1);

		DeleteNodeFromNode obj = new DeleteNodeFromNode();
		assertTrue(obj.deleteByNode(n3));

	}
}
