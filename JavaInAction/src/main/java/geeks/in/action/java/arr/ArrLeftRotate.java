package geeks.in.action.java.arr;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by manishdevraj on 03/04/18.
 */
public class ArrLeftRotate {
    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int[] arr = new int[n];
        for(int i=0; i < n; i++) {
            int newIndex = (i + (n - k)) % n;
            arr[newIndex] = a[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }
}
