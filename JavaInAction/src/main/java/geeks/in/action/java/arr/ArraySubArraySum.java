package geeks.in.action.java.arr;

import java.util.Arrays;

/**
 * Given an array, arr, we define the following:

 •	A subarray of arr is an array composed from a contiguous block of arr's elements.
 For example, the subarrays of arr = [1, 2, 3] are [1], [2], [3], [1, 2], [2, 3], and [1, 2, 3].
 •	The subarray sum of arr is the sum of the elements of all subarrays of arr. For example, if arr = [1, 2, 3],
 then the subarray sum is (1) + (2) + (3) + (1 + 2) + (2 + 3) + (1 + 2 + 3) = 20.

 Complete the subarraySum function in the editor below. It has one parameter: an array of integers, arr.
 The function must return a long integer denoting the subarray sum of arr.


 * Created by manishdevraj on 20/03/18.
 */
public class ArraySubArraySum {

    /**
     * Input Format
     Locked stub code in the editor reads the following input from stdin and passes it to the function:
     The first line contains an integer, n, denoting the number of elements in arr.
     Each line i of the n subsequent lines (where 0 ≤ i < n) contains an integer describing arri.

     Constraints
     •	1 ≤ n ≤ 2 × 105
     •	1 ≤ arri ≤ 103, where 0 ≤ i < n

     Output Format
     The function must return a long integer denoting the subarray sum of arr.

     */

    /**
     * The basic idea behind the approach is to compute the sum, but not in the order intended.
     * For example, take a look at the array [1, 2, 3, 4]. The subarrays are

     [1] [2] [3] [4]

     [1, 2] [2, 3] [3, 4]

     [1, 2, 3] [2, 3, 4]

     [1, 2, 3, 4]

     Notice how many copies of each element there are. There are four 1's, six 2's, six 3's, and four 4's.
     If we could efficiently compute how many copies of each element there are across all the different subarrays,
     we could directly compute the sum by multiply each element in the array by the number of times it appears across
     all the subarrays and then adding them up. You can find a bunch of interesting patterns with how many times each
     number shows up. Here's one useful one. We can count the number of subarrays that overlap a particu￾lar element
     at index i by counting those subarrays and focusing on the index at which those subarrays start.
     The first element of the array will appear in n different subarrays – each of them starts at the first position.
     The second element of the array will appear in n­1 subarrays that begin at its position, plus n­1 subarrays from
     the previous position (there are n total intervals, of which one has length one and therefore won't reach the
     second element). The third element of the array will appear in n­2 subarrays that begin in its position,
     plus n­2 subarrays beginning at the first element (all n arrays, minus the one of length two and the one of length
     one) and n­2 subarrays beginning at the second ele￾ment (all n­1 of them except for the one of length one).
     More generally, the ith element will open n – i new intervals (one for each length stretching out to the end)
     and, for each preceding element, will overlap n – i of the intervals starting there.

     This means that the total number of intervals overlapping element i is given by (n – i)i + (n – i) = (n – i)(i + 1)
     Consequently, we can solve this problem by multiplying each element in the array by this scaling factor and taking
     the sum.

     This runs in O(n) time and uses only O(1) space.
     * @param arr
     * @return
     */
    public long subArraySum(long[] arr){
        long sum = 0;

        for (int i = 0 ; i < arr.length ; i++){
            sum += arr[i] * (i + 1) * (arr.length - i);
        }

        return sum;
    }
}
