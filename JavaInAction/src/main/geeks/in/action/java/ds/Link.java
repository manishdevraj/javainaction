package geeks.in.action.java.ds;

public class Link {

	// Set to public so getters & setters aren't needed

	public String bookName;
	public int millionsSold;

	// Reference to next link made in the LinkList
	// Holds the reference to the Link that was created before it
	// Set to null until it is connected to other links

	public Link next;

	public Link(String bookName, int millionsSold) {

		this.bookName = bookName;
		this.millionsSold = millionsSold;

	}

	public void display() {

		System.out.println(bookName + ": " + millionsSold + ",000,000 Sold");

	}

	@Override
	public String toString() {

		return bookName;

	}

	public static void main(String[] args) {

		SingleLinkList theLinkedList = new SingleLinkList();

		// Insert Link and add a reference to the book Link added just prior
		// to the field next

		theLinkedList.addBefore("Don Quixote", 500);
		theLinkedList.addBefore("A Tale of Two Cities", 200);
		theLinkedList.addBefore("The Lord of the Rings", 150);
		theLinkedList.addBefore("Harry Potter and the Sorcerer's Stone", 107);

		theLinkedList.display();

		System.out.println("Value of first in LinkedList "
				+ theLinkedList.firstLink + "\n");

		// Removes the last Link entered
		theLinkedList.removeFirst();

		theLinkedList.display();

		System.out.println(theLinkedList.find("The Lord of the Rings").bookName
				+ " Was Found");

		theLinkedList.removeLink("A Tale of Two Cities");

		System.out.println("\nA Tale of Two Cities Removed\n");

		theLinkedList.display();

	}

}
