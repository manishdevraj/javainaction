package geeks.in.action.oops;

/**
 * Interface hack that can allow it to store mutable objects within interface
 * Won't really benefit in real life but to understand concept
 * 
 * @author manishdevraj
 * 
 */
public interface TrickyInterface {

	void method1();

	abstract void method2();

	// This is illegal as everything should be non-private
	// private void method3();

	String CONSTANT = "CONSTANT";

	static class HackInterface {
		public static String CONSTANT = "NEWCONSTANT";

		public static void setConstant(String constant) {
			CONSTANT = constant;
		}
	}
}
