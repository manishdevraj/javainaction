package org.edu.stiffy.algo;

import java.util.Scanner;

/**
 * Swap 2 numbers without using 3rd variable
 * 
 * @author manishdevraj
 * 
 */
public class Swap2without3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter No. 1");
		int n1 = scan.nextInt();
		System.out.println("Please Enter No. 2");
		int n2 = scan.nextInt();
		n1 = n1 + n2;
		n2 = n1 - n2;
		n1 = n1 - n2;
		System.out.println("Swap n1 " + n1 + " and " + n2);
	}
}
