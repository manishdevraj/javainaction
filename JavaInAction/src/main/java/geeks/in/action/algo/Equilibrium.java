package geeks.in.action.algo;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. Array A
 * represents numbers on a tape. Any integer P, such that 0 < P < N, splits this
 * tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1],
 * ..., A[N − 1]. The difference between the two parts is the value of: |(A[0] +
 * A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])| In other words,
 * it is the absolute difference between the sum of the first part and the sum
 * of the second part.
 * 
 * @author manishdevraj
 * 
 */
public class Equilibrium {

	public int solution(final int[] A) {
		long min;
		long rightSum = 0;
		int len = A.length;
		long leftSum = A[0];
		for (int i = 1; i < len; i++) {
			rightSum += A[i];
		}
		min = Math.abs(rightSum - leftSum);
		for (int i = 1; i < len; i++) {
			long result = Math.abs(leftSum - rightSum);
			if (result < min) {
				min = result;
			}
			leftSum += A[i];
			rightSum -= A[i];
		}
		return (int) min;
	}
}
