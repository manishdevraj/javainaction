package geeks.in.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import geeks.in.action.java.arr.*;

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

	@Test
	public void testFindDuplicateIntArray() {
		ArrayDuplicate obj = new ArrayDuplicate();
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(arr1));
		assertFalse(obj.findDuplicate(arr1));

		int[] arr2 = { 1, 2, 3, 4, 5, 2, 7, 8, 9 };
		System.out.println(Arrays.toString(arr2));
		assertTrue(obj.findDuplicate(arr2));
	}

	@Test
	public void testMaxFreqArray() {
		ArrayMaxFreq obj = new ArrayMaxFreq();
		int arr[] = {2, 3, 3, 2, 5};
		System.out.println(Arrays.toString(arr));
		assertEquals(2, obj.findMaxFrequency(arr, arr.length));

		int arr1[] = {1};
		System.out.println(Arrays.toString(arr1));
		assertEquals(1, obj.findMaxFrequency(arr1, arr1.length));

		int arr2[] = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1};
		System.out.println(Arrays.toString(arr2));
		assertEquals(3, obj.findMaxFrequency(arr2, arr2.length));

		int arr3[] = {4, 4, 4, 4};
		System.out.println(Arrays.toString(arr3));
		assertEquals(4, obj.findMaxFrequency(arr3, arr3.length));

		int arr4[] = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
		System.out.println(Arrays.toString(arr4));
		assertEquals(11, obj.findMaxFrequency(arr4, arr4.length));

		int arr5[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		System.out.println(Arrays.toString(arr5));
		assertEquals(1, obj.findMaxFrequency(arr5, arr5.length));

		int arr6[] = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println(Arrays.toString(arr6));
		assertEquals(1, obj.findMaxFrequency(arr6, arr6.length));
	}

	@Test
	public void testSubArraySum() {
		ArraySubArraySum obj = new ArraySubArraySum();
		long arr[] = {1, 2, 3, 4};
		System.out.println(Arrays.toString(arr));
		assertEquals(50, obj.subArraySum(arr));

		long arr1[] = {1, 2, 3};
		System.out.println(Arrays.toString(arr1));
		assertEquals(20, obj.subArraySum(arr1));

		long arr2[] = {1, 3, 4};
		System.out.println(Arrays.toString(arr2));
		assertEquals(27, obj.subArraySum(arr2));
	}

	@Test
	public void testArrayThirdLargestIndex() {
		ArrayThirdLargestIndex obj = new ArrayThirdLargestIndex();
		int arr[] = {12, 45, 17, 14, 21};
		System.out.println(Arrays.toString(arr));
		assertEquals(2, obj.getThirdLargestIndex(arr));

		int arr1[] = {100, 50, 10, 20, 1};
		System.out.println(Arrays.toString(arr1));
		assertEquals(3, obj.getThirdLargestIndex(arr1));

		int arr2[] = {1, 1, 1};
		System.out.println(Arrays.toString(arr2));
		assertEquals(-1, obj.getThirdLargestIndex(arr2));
	}

	@Test
	public void findMissingNumberinArray() {
		final int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 0, 9, 10 };
		MissingNumArray obj = new MissingNumArray();
		int missingNumber = obj.findMissingNumberBitWise(array1);
		System.out.println("Array is missing " + missingNumber);
	}



}
