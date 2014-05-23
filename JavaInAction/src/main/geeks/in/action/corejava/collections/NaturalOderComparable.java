package geeks.in.action.corejava.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Natural order comparable based on String length. It also uses Comparator that
 * can add additional functionality based on comparison nature
 * 
 * @author manishdevraj
 * 
 */
class Customer implements Comparable<Customer> {
	private final String name;

	public Customer(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	// Natural oder based on String length
	// We need to put additional logic for strings with equal length
	// but they are different strings
	@Override
	public int compareTo(Customer o) {
		int len1 = name.length();
		int len2 = o.name.length();
		if (len1 > len2) {
			return 1;
		} else if (len1 < len2) {
			return -1;
		} else {
			// instead of returning 0 which would exclude string of same length
			// return 0;
			return this.name.compareTo(o.name);
		}

	}

	public static Comparator<Customer> StringNameComparator = new Comparator<Customer>() {

		@Override
		public int compare(Customer o1, Customer o2) {
			return o1.getName().compareTo(o2.getName());
		}

	};

}

public class NaturalOderComparable {

	public static void main(String[] args) {
		List<Customer> customerList = new ArrayList<Customer>();
		SortedSet<Customer> sortedSet = new TreeSet<Customer>();
		// Using comparable
		addElement(customerList);
		addElement(sortedSet);
		Collections.sort(customerList);
		System.out.println("##Display List##");
		displayElement(customerList);
		System.out.println("**Display Set**");
		displayElement(sortedSet);

		// Using comparator
		Collections.sort(customerList, Customer.StringNameComparator);
		System.out.println("##Display List as Comparator##");
		displayElement(customerList);
	}

	private static void addElement(Collection<Customer> col) {
		col.add(new Customer("Manish"));
		col.add(new Customer("Niraj"));
		col.add(new Customer("Vinod"));
		col.add(new Customer("Dinesh"));
		col.add(new Customer("Spyd"));
	}

	private static void displayElement(Collection<Customer> col) {
		for (Customer customer : col) {
			System.out.println(customer);
		}
	}

}
