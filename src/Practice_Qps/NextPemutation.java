package Practice_Qps;

public class NextPemutation {
    public static void main(String[] args) {
        
    }

    public static void nextPermutation(int[] nums) {
        // find the first decreasing number from right
        int i = nums.length-2;
        while(i >= 0 && nums[i+1] <= nums[i]) {
            i--;
        }

        // here i is pointing to the first decreasing number
        if(i > 0) {
            int j = nums.length-1;
            // find first number greater than the number at ith index
            while(nums[j] <= nums[i]) {
                j--;
            } 

            // j points towards the number which is greater than the number at ith index
            // swap them
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reverse(nums, i+1, nums.length-1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }
}
