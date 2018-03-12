package geeks.in.action;

import geeks.in.action.java.strings.ArrayRotate;
import geeks.in.action.java.strings.ArrayZeroRowCol;

import java.util.Arrays;

import org.junit.Test;

public class ArrayTest extends BaseTestCase {

	@Test
	public void testRotateArray() {
		ArrayRotate obj = new ArrayRotate();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n")
				.replace("[[", "[").replace("]]", "]"));
		obj.rotate(matrix, 3);
		System.out.println("-------------------");
		System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n")
				.replace("[[", "[").replace("]]", "]"));

	}

	@Test
	public void testMarkZeroRowColToZero() {
		ArrayZeroRowCol obj = new ArrayZeroRowCol();
		int[][] matrix = { { 1, 0, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
		System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n")
				.replace("[[", "[").replace("]]", "]"));
		obj.setZeros(matrix);
		System.out.println("-------------------");
		System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n")
				.replace("[[", "[").replace("]]", "]"));

	}
}
