package striver_sheet;

import java.util.Arrays;

public class RepeatAndMissing {
    public static void main(String[] args) {
        int[] arr = {3,1,2,5,3};
        int[] ans = repeatedAndMissingNumber(arr);
        System.out.println(Arrays.toString(ans));
    }

    // keep in mind that array contains element in the range [1,n]
    // [3 1 2 5 3] -> cyclic sort -> [1,2,3,5,3] repeated element is on the last of the array and missing element is
    //                index at which the repeated element is present
    public static int[] repeatedAndMissingNumber(final int[] arr) {
        cyclicSort(arr);
        int[] ans = new int[2];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != i+1) {
                ans[0] = arr[i]; // repeated element
                ans[1] = i+1; // missing element
            }
        }
        return ans;
    }

    private static void cyclicSort(final int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }
    }
}
