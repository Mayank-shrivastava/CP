package Practice_Qps;
import java.util.*;
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
        
    }
    public static int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);
        int ans = 0;
        for(int num : set) {
            // if num-1 is not in the set this condition will avoid check for condition which already checked
            if(!set.contains(num-1)) {
                int currNum = num;
                int currLen = 1;
                while(set.contains(currNum+1)) {
                    currNum+=1;
                    currLen+=1;
                }
                ans = Math.max(currLen, ans); 
            }
        }

        return ans;

    }    
}
