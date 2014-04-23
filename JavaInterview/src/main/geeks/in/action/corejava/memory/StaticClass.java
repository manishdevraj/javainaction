package geeks.in.action.corejava.memory;

public class StaticClass {
	private static int count;

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		StaticClass.count = count;
	}
}
