package geeks.in.action.java.strings;

/**
 * Given an array of n integers, we define its degree as the maximum frequency of any element in the array.
 * For example, the array [1, 2, 3, 4, 2, 2, 3] has a degree of 3 because the number 2 occurs three times
 * (which is more than any other number in the array). We want to know the size of the smallest subarray of our
 * array such that the subarray's degree is equal to the array's degree. For example, the array [1, 2, 2, 3, 1]
 * has a degree of 2 because 1 and 2 occur a maximal two times. There are two possible subarrays with this degree:
 * [1, 2, 2, 3, 1] and [2, 2]. Our answer is the length of the smallest subarray, which is 2.
 Complete the function in the editor below. It has one parameter: an array of n integers, arr. The function must
 return an integer denoting the minimum size of the subarray such that the degree of the subarray is equal to the
 degree of the array.

 * Created by manishdevraj on 20/03/18.
 */
public class ArrayMaxFreq {

    /**
     * Input Format
     The first line contains an integer, n, denoting the number of elements in arr.
     Each line i of the n subsequent lines (where 0 ≤ i < n) contains an integer describing arri.
     Constraints
     •	1 ≤ n ≤ 105
     •	1 ≤ arri ≤ 106
     Output Format
     Return an integer denoting the minimum size of the subarray such that the degree of the subarray is equal
     to the degree of the array.

     */

    // Function to find counts of all elements present in
    // arr[0..n-1]. The array elements must be range from
    // 1 to n
    //Return maxFrequency among all
    public int findMaxFrequency(int arr[], int n)
    {
        // Traverse all array elements
        int i = 0;
        while (i < n)
        {
            // If this element is already processed,
            // then nothing to do
            if (arr[i] <= 0)
            {
                i++;
                continue;
            }

            // Find index corresponding to this element
            // For example, index for 5 is 4
            int elementIndex = arr[i] - 1;

            // If the elementIndex has an element that is not
            // processed yet, then first store that element
            // to arr[i] so that we don't loose anything.
            if (arr[elementIndex] > 0)
            {
                arr[i] = arr[elementIndex];

                // After storing arr[elementIndex], change it
                // to store initial count of 'arr[i]'
                arr[elementIndex] = -1;
            }
            else
            {
                // If this is NOT first occurrence of arr[i],
                // then increment its count.
                arr[elementIndex]--;

                // And initialize arr[i] as 0 means the element
                // 'i+1' is not seen so far
                arr[i] = 0;
                i++;
            }
        }

        System.out.println("Below are counts of all elements");
        int max = 0;
        for (int j = 0; j < n; j++)
        {
            int val = Math.abs(arr[j]);
            if (val > max)
                max = val;
            System.out.println(j+1 + "->" + val);
        }

        return max;
    }
}
