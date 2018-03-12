package geeks.in.action;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import geeks.in.action.java.memory.StaticClassLoader;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

/**
 * Test case for testing memory related programs
 * 
 * @author manishdevraj
 * 
 */
public class MemoryTest extends BaseTestCase {

	@Test
	public void staticMemberTestUsingClassLoader() {
		StaticClassLoader clazzLoader1 = new StaticClassLoader();
		StaticClassLoader clazzLoader2 = new StaticClassLoader();
		if (clazzLoader1.equals(clazzLoader2)) {
			System.out.println("We are using same class loaders");
		} else {
			System.out.println("We are good to go, classloaders are different");
		}

		assertNotEquals(clazzLoader1, clazzLoader2);

		Class<?> clazzOne = null;
		Class<?> clazzTwo = null;
		try {
			clazzOne = Class.forName(
					"org.edu.stiffy.corejava.memory.StaticClass", true,
					clazzLoader1);
			clazzTwo = Class.forName(
					"org.edu.stiffy.corejava.memory.StaticClass", true,
					clazzLoader2);

			Object instanceOne = clazzOne.newInstance();
			Object instanceTwo = clazzTwo.newInstance();

			if (clazzOne.equals(clazzTwo)) {
				System.out
						.println("Class loaded in different custome classloader are same");
			} else {
				System.out
						.println("Class loaded in different custome classloader are different.");
			}

			assertNotEquals(clazzOne, clazzTwo);

			clazzOne.getMethod("setCount", int.class).invoke(instanceOne, 10);
			clazzTwo.getMethod("setCount", int.class).invoke(instanceTwo, 20);

			System.out.println("The static member count value in "
					+ instanceOne + " is "
					+ clazzOne.getMethod("getCount").invoke(instanceOne));

			System.out.println("The static member count value in "
					+ instanceTwo + " is "
					+ clazzTwo.getMethod("getCount").invoke(instanceTwo));

			assertNotEquals(clazzOne.getMethod("getCount").invoke(instanceOne),
					clazzTwo.getMethod("getCount").invoke(instanceTwo));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		} catch (InstantiationException e) {
			e.printStackTrace();
			fail();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			fail();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			fail();
		} catch (SecurityException e) {
			e.printStackTrace();
			fail();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			fail();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			fail();
		}

	}
}
