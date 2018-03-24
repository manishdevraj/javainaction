package geeks.in.action.java.ds;

import java.util.Arrays;

/**
 * Created by manishdevraj on 24/03/18.
 */
public class MaxHeap {
    int[] data = {};

    public void buildMaxHeap(int[] arr){
        data = arr;
        for( int i = (int)Math.floor( data.length - 1 ); i >= 0; i-- )
            maxHeapify( data, i );
        System.out.println("Heapified "  + Arrays.toString(data));
    }

    // A recursive method to heapify a subtree with root at given index
    // This method assumes that the subtrees are already heapified
    public void maxHeapify(int[] arr, int i){

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if( left < arr.length && arr[left] > arr[largest] )
            largest = left;
        if( right < arr.length && arr[right] > arr[largest] )
            largest = right;

        if( largest != i ){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify( arr, largest );
        }
    }


    public int extractMax(int[] arr)
    {
        if (arr.length == 0)
            return Integer.MAX_VALUE;

        // Store the maximum value.
        int root = arr[0];

        // If there are more than 1 items, move the last item to root
        // and call heapify.
        if (arr.length > 1)
        {
            data = Arrays.copyOfRange(arr, 1, arr.length);
            buildMaxHeap(data);
        }
        return root;
    }

    // Function to return k'th largest element in a given array
    public int kthLargest(int arr[], int n, int k)
    {

        if(n < k) return Integer.MAX_VALUE;

        // Build a heap of n elements: O(n) time
        buildMaxHeap(arr);

        // Do extract max times
        for (int i=0; i < k; i++)
        {
            int max = extractMax(data);
            System.out.println("Max at " + (i+1) + ", " + max);
            System.out.println(Arrays.toString(data));
        }

        // Return root
        return (data.length > 0) ? data[0] : Integer.MAX_VALUE;
    }

    public static void main(String[] args)
    {
        int arr[] = {12, 3, 5, 7, 19};
        System.out.println("Original array " + Arrays.toString(arr));
        MaxHeap obj = new MaxHeap();
        System.out.println("K'th smallest element is " + obj.kthLargest(arr, arr.length, 3));
    }
}
