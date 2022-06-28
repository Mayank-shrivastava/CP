package DP;

public class LISnlogn {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(lisUsingBinarySearch(arr));
    }

    public static int lisUsingBinarySearch(int[] arr) {
        int[] lis = new int[arr.length];
        lis[0] = arr[0];
        int len = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > lis[len-1]) {
                lis[len] = arr[i];
                len++;
            } else {
                int ind = binarySearch(0, len - 1, lis, arr[i]);
                // lower bound method that will return first index whic is greater than or equal to arr[i]
                lis[ind] = arr[i];
            }
        }

        return len;
    }

    private static int binarySearch(int start, int end, int[] lis, int k) {
        int ans = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (lis[mid] >= k) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}