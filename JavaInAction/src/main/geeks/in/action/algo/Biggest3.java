package geeks.in.action.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Find biggest number among 3
 * 
 * @author manishdevraj
 * 
 */
public class Biggest3 {
	public static void main(String[] args) {
		// List<Integer> nums = new ArrayList<Integer>();
		// nums.add(1);
		// nums.add(2);
		// nums.add(3);
		// nums.add(5);
		// nums.add(8);
		//
		// nums.remove(2);
		// System.out.println(nums);

		List<String> list = Arrays.asList("Ryan", "Julie", "Bob");
		list.remove("Ryan");
		System.out.println(list);

	}

	public static void _main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashSet<Integer> temp = new HashSet<Integer>();
		System.out.println("Please Enter No. 1");
		int n1 = scan.nextInt();
		System.out.println("Please Enter No. 2");
		int n2 = scan.nextInt();
		System.out.println("Please Enter No. 3");
		int n3 = scan.nextInt();
		int big;
		if (n1 > n2 && n1 > n3) {
			big = n1;
		} else if (n2 > n1 && n2 > n3) {
			big = n2;
		} else {
			big = n3;
		}
		System.out.println("Biggest of " + n1 + ", " + n2 + ", " + n3 + " is "
				+ big);

	}
}
