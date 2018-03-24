package geeks.in.action.java.strings;

/**
 *  Given an array of numbers find the index of the 3rd largest number.

 Ex 12,45, 17,14,21

 Output : 2=

 * Created by manishdevraj on 24/03/18.
 */
public class ArrayThirdLargestIndex {


    public int getThirdLargestIndex(final int[] arr){

        if(arr == null && arr.length < 3 )
            return -1;

        if(arr.length == 1)
            return 0;

        int firstMax = arr[0];
        int secondMax = Integer.MIN_VALUE;
        int thirdMax =  Integer.MIN_VALUE;

        int firstMaxIndex = 0;
        int secondMaxIndex = -1;
        int thirdMaxIndex = -1;
        int len = arr.length;

        for(int i = 1; i < len; i++){
            if(arr[i] > firstMax){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = arr[i];

                thirdMaxIndex = secondMaxIndex;
                secondMaxIndex = firstMaxIndex;
                firstMaxIndex = i;
            } else if (arr[i] > secondMax && arr[i] != firstMax){
                thirdMax = secondMax;
                secondMax = arr[i];

                thirdMaxIndex = secondMaxIndex;
                secondMaxIndex = i;
            } else if (arr[i] > thirdMax && arr[i] != firstMax){
                thirdMax = arr[i];
                thirdMaxIndex = i;
            }
        }
        return thirdMaxIndex;

    }


   // arr = {1,1,1,1,1,1}


//
}
