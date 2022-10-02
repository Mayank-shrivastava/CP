package Practice_Qps;
import java.util.*;
public class sum3{
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue; // just for avoiding duplicate answers
            helper(i,-nums[i],nums, result);
        }
        return result;
    }

    private static void helper(int idx, int target, int[] nums, List<List<Integer>> result) {
        int start = idx+1;
        int end = nums.length-1;
        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum > target) {
                end--;
            } else if(sum < target) {
                start++;
            } else {
                result.add(List.of(-target, nums[start], nums[end]));
                start++;
                while(nums[start] == nums[start-1] && start < end) {
                    start++;
                }
            }
        }
    }
    
}
