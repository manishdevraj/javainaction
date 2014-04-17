package org.edu.stiffy.algo;

/**
 * Reverse string / Swap characters
 * 
 * @author manishdevraj
 * 
 */
public class StringCharMove {

	public static void main(String[] args) {
		String baseStr = "ketaki";
		System.out.println("String " + baseStr);
		char[] charArray = baseStr.toCharArray();
		int len = charArray.length - 1;
		for (int i = 0, j = len; i <= len / 2 && j >= len / 2; i++, j--) {
			swap(charArray, i, j);
		}
		System.out.println("New String " + new String(charArray));
	}

	private static void swap(char[] charArray, int i, int j) {
		char c = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = c;
	}

}
