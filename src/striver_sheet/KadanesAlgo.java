package striver_sheet;

public class KadanesAlgo {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = maxSubArraySum(nums);
        System.out.println(ans);
    }

    public static int maxSubArraySum(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(currSum > 0) {
                currSum += nums[i];
            } else {
                currSum = nums[i];
            }

            if(currSum > maxSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }
}
