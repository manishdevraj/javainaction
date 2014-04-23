package geeks.in.action.oops;

/**
 * Inheritance and overriding
 * 
 * @author manishdevraj
 * 
 */
public class SuperOverride {

	public static void main(String[] args) {
		ChildOverride childObj = new ChildOverride();
		System.out.println("Result: " + childObj.add(10, 20.1));
	}

	protected int add(int i, int j) {
		return i += j;
	}
}
