package Sorting;
import java.util.*;
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64,25,12,22,11};

        for(int i = 0; i < arr.length-1; i++) {
            int minInd = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minInd]) minInd = j;
            }

            // swap arr[minInd] and arr[j]
            int temp = arr[minInd];
            arr[minInd] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
