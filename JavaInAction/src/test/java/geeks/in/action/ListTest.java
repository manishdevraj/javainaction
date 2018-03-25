package geeks.in.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import geeks.in.action.java.collections.list.*;

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

	@Test
	public void testAddLinkedList() {
		AddTwoLists obj = new AddTwoLists();

		AddTwoLists.Link l1 = new AddTwoLists.Link(3);
		l1.appendToTail(1);
		l1.appendToTail(5);

		AddTwoLists.Link l2 = new AddTwoLists.Link(5);
		l2.appendToTail(9);
		l2.appendToTail(2);

		System.out.println("Link 1 : " + l1);
		System.out.println("Link 2 : " + l2);

		AddTwoLists.Link result = obj.addLists(l1, l2, 0);
		System.out.println("Result : " + result);

		assertEquals(Integer.valueOf(8), result.data);
		assertEquals(Integer.valueOf(0), result.next.data);
		assertEquals(Integer.valueOf(8), result.next.next.data);

	}

	@Test
	public void testFindStartOfCircularList() {
		CircularFindFirst.Link n1 = new CircularFindFirst.Link("A");
		CircularFindFirst.Link n2 = new CircularFindFirst.Link("B");
		CircularFindFirst.Link n3 = new CircularFindFirst.Link("C");
		CircularFindFirst.Link n4 = new CircularFindFirst.Link("D");
		CircularFindFirst.Link n5 = new CircularFindFirst.Link("E");

		n1.next = n2;
		n2.next = n3;

		n3.next = n4;
		n4.next = n5;
		n5.next = n3;

		System.out.println("Circular Link : " + n1);

		CircularFindFirst obj = new CircularFindFirst();

		CircularFindFirst.Link head = obj.findBegining(n1);

		System.out.println("head : " + head);

		assertEquals("C", head.data);
	}
}
