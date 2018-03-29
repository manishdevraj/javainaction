package geeks.in.action.java.arr;

/**
 * Find if a integer array has any duplicate numbers
 * 
 * @author manishdevraj
 * 
 */
public class ArrayDuplicate {

	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean findDuplicate(final int[] array) {
		for (int val : array) {
			int index = Math.abs(val) - 1;
			if (array[index] < 0)
				return true;
			array[index] *= -1;
		}
		return false;
	}

	/**
     * Write an efficient a program to find the sum of contiguous subarray within a
     * one-dimensional array of numbers which has the largest sum
     *
     * @author manishdevraj
     *
     */
    public static class LargSumContSubArray {

        /**
         * Simple idea of the Kadane's algorithm is to look for all positive
         * contiguous segments of the array (max_ending_here is used for this). And
         * keep track of maximum sum contiguous segment among all positive segments
         * (max_so_far is used for this). Each time we get a positive sum compare it
         * with max_so_far and update max_so_far if it is greater than max_so_far
         */
        public static void main(String[] args) {
            int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
            System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
        }

        private static int maxSubArraySum(int a[]) {
            int size = a.length;
            int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

            for (int i = 0; i < size; i++) {
                max_ending_here = max_ending_here + a[i];
                if (max_so_far < max_ending_here)
                    max_so_far = max_ending_here;
                if (max_ending_here < 0)
                    max_ending_here = 0;
            }
            return max_so_far;
        }
    }

	/**
     * Find missing number in an array
     *
     * @author manishdevraj
     *
     */
    public static class MissingNumArray {

        public Number findMissingNumber(Number[] numArray) {
            int size = numArray.length;
            Number missingNum;
            Number missingIndex;// return this as index if required
            long sum = 0;
            for (int i = 0; i < size; i++) {
                if (numArray[i].intValue() == 0) {
                    missingIndex = new Integer(i);
                } else {
                    sum += numArray[i].longValue();
                }
            }
            missingNum = ((size + 1) * size) / 2 - sum;
            return missingNum;
        }

    }
}
