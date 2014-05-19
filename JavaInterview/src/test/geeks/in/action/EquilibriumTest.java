package geeks.in.action;

import static org.junit.Assert.assertEquals;
import geeks.in.action.algo.Equilibrium;

import org.junit.Test;

public class EquilibriumTest extends BaseTestCase {

	private final Equilibrium eq = new Equilibrium();

	@Test
	public void testSample() {
		int[] A = { 3, 1, 2, 4, 3 };
		assertEquals(1, eq.solution(A));
	}

	@Test
	public void testTwo() {
		int[] A = { 3000, 1000 };
		assertEquals(2000, eq.solution(A));
	}

	@Test
	public void testNegatives() {
		int[] A = { -3000, 1000, 4000, 2000 };
		assertEquals(0, eq.solution(A));
	}
}
