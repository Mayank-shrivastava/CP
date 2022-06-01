package striver_sheet;

import java.util.Arrays;

public class CountInversion {
    public static void main(String[] args) {
        long[] arr = {8,4,2,1};
        System.out.println(getInversion(arr,arr.length));
    }

    public static long getInversion(long[] arr ,int n) {

        return mergeSort(arr, 0, n-1);
    }

    // recursive method with base-case l > r
    public static long mergeSort(long[] arr, int l, int r) {
        long invCnt = 0;
        int mid = 0;
        if(l < r) {
            mid = (l + r) / 2;
            invCnt += mergeSort(arr, l, mid);
            invCnt += mergeSort(arr, mid + 1, r);
            invCnt += merge(arr,l, mid, r);
        }
        return invCnt;
    }

    public static long merge(long[] arr, int l, int mid, int r) {
        long[] left = Arrays.copyOfRange(arr, l,mid+1);
        long[] right = Arrays.copyOfRange(arr, mid+1,r+1);
        int i = 0;
        int j = 0;
        int k = l;
        long invCnt = 0;
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                k++;
                i++;
            } else {
                arr[k] = right[j];
                k++;
                j++;
                invCnt += (mid+1) - (l+i);
            }
        }

        while(i < left.length) {
            arr[k] = left[i];
            k++;
            i++;
        }

        while(j < right.length) {
            arr[k] = right[j];
            k++;
            j++;
        }
        return invCnt;
    }
}
