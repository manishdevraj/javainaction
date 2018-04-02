package geeks.in.action.java.arr;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Print the largest (maximum) hourglass sum found in .
 *
 * Sample Input

 1 1 1 0 0 0
 0 1 0 0 0 0
 1 1 1 0 0 0
 0 0 2 4 4 0
 0 0 0 2 0 0
 0 0 1 2 4 0
 Sample Output

 19
 Explanation

 contains the following hourglasses:

 1 1 1   1 1 0   1 0 0   0 0 0
   1       0       0       0
 1 1 1   1 1 0   1 0 0   0 0 0

 0 1 0   1 0 0   0 0 0   0 0 0
   1       1       0       0
 0 0 2   0 2 4   2 4 4   4 4 0

 1 1 1   1 1 0   1 0 0   0 0 0
   0       2       4       4
 0 0 0   0 0 2   0 2 0   2 0 0

 0 0 2   0 2 4   2 4 4   4 4 0
   0       0       2       0
 0 0 1   0 1 2   1 2 4   2 4 0
 The hourglass with the maximum sum () is:

 2 4 4
   2
 1 2 4

 * Created by manishdevraj on 01/04/18.
 */
public class ArrHourGlassMaxSum {

    public static void main(String[] args) {
        int arr[][] =
                {{1, 1, 1, 0, 0, 0},
                    {0, 1, 0, 0, 0, 0},
                    {1, 1, 1, 0, 0, 0},
                    {0, 0, 2, 4, 4, 0},
                    {0, 0, 0, 2, 0, 0},
                    {0, 0, 1, 2, 4, 0}};
        calculateMaxHourGlass(arr);
    }

    private static void calculateMaxHourGlass(int arr[][]){
        int max = Integer.MIN_VALUE;
        if(arr != null && arr.length > 0) {
            int width = arr[0].length;
            int height = arr.length;
            int sum = 0;
            for(int i = 0; (i + 3) <= height; i++){
                for(int j = 0; (j + 3) <= width; j++){
                    int right = 3;
                    int row = i;
                    int col = j;
                    int flag = 0;
                    while (right != 0) {
                        if((flag & 1) == 1) {
                            sum += arr[row][++col];
                            flag = 0;
                        } else {
                            int count = 3;
                            while(row <= height && count != 0) {
                                sum += arr[row][col++];
                                count--;
                            }
                            flag = 1;
                        }
                        col = j;
                        row++;
                        right--;
                    }

                    if (sum > max)
                        max = sum;

                    sum = 0;
                }
            }
            System.out.println(max);
        }
    }
}


