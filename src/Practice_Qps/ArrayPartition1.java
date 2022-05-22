package Practice_Qps;

import java.util.*;
public class ArrayPartition1 {
    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        int ans = arrayPairSum(nums);
        System.out.println(ans);
    }
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums); // sort the array
        int sum = 0;
        for(int i = 0; i < nums.length; i+=2) {
            sum += Math.min(nums[i],nums[i+1]);
        }

        return sum;
    }
}
