package geeks.in.action.java.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Iterator implementation using custom iterator
 * 
 * @author manishdevraj
 * 
 */
class Books implements Iterable<String> {
	List<String> bookList = new LinkedList<String>();

	public Books() {
		bookList.add("Core Java");
		bookList.add("Advanced Java");
		bookList.add("Spring");
		bookList.add("Hibernate");
	}

	// Custom book iterator that iterates over map of books
	private class BookIterator implements Iterator<String> {
		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < bookList.size();
		}

		@Override
		public String next() {
			return bookList.get(index++);

		}

		@Override
		public void remove() {
			bookList.remove(index);
		}
	}

	@Override
	public Iterator<String> iterator() {
		return new BookIterator();
	}
}

public class IterableCustomCollection {

	public static void main(String[] args) {
		Books books = new Books();
		for (String name : books) {
			System.out.println(name);
		}

	}

}
