package geeks.in.action.corejava.collections;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Custom object that needs to be used as key in HashMap and Set If it is not
 * mutable then it will not identify logical similar objects
 * 
 * @author manishdevraj
 * 
 */
class Person {

	private final int id;
	private final String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[ID = " + this.id + "; Name = " + this.name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

public class CustomObjMapNSet {

	public static void main(String[] args) {
		Person p1 = new Person(1, "Manish");
		Person p2 = new Person(2, "Niraj");
		Person p3 = new Person(3, "Vinod");
		Person p4 = new Person(2, "Niraj");

		Map<Person, String> linkedMap = new LinkedHashMap<Person, String>();
		linkedMap.put(p1, "Manish");
		linkedMap.put(p2, "Niraj");
		linkedMap.put(p3, "Vinod");
		linkedMap.put(p4, "Niraj");

		for (Person key : linkedMap.keySet()) {
			System.out.println(key + " = " + linkedMap.get(key));
		}

		Set<Person> personSet = new LinkedHashSet<Person>();
		personSet.add(p1);
		personSet.add(p2);
		personSet.add(p3);
		personSet.add(p4);

		System.out.println(personSet);

	}

}
