package geeks.in.action.algo;

/**
 * (0 1 1 2 3 5 8 13...) Sum of previous number will give us next number This is
 * simplest way to find Fibonacci series number up to n
 * 
 * @author manishdevraj
 * 
 */
public class Fibonacci {

	public int fibonacci(int n) {
		if (n == 0 || n == 1)
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
