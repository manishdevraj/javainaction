package geeks.in.action.algo;

import java.util.Scanner;

/**
 * Find prime numbers Divisible by only itself
 * 
 * @author manishdevraj
 * 
 */
public class Prime {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter a No.");
		int n = scan.nextInt();
		int res;
		boolean flag = false;
		for (int i = 2; i <= n / 2; i++) {
			res = n % i;
			if (res != 0) {
				flag = true;
				break;
			} else if (res == 0) {
				flag = false;
				break;
			}
		}

		if (flag) {
			System.out.println(n + " is Prime Number");
		} else {
			System.out.println(n + " is Prime NOT Number");
		}
	}
}
