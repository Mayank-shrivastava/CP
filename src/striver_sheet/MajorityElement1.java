package striver_sheet;

import java.util.HashMap;

public class MajorityElement1 {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElementUsingHashMap(nums));
    }

    // TC: O(N)
    // SC: O(N)
    public static int majorityElementUsingHashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums) {
            if(!map.containsKey(ele)) {
                map.put(ele, 1);
            } else {
                map.put(ele, map.get(ele) + 1);
            }
        }

        for(int key : map.keySet()) {
            if(map.get(key) > nums.length/2) {
                return key;
            }
        }
        return -1;
    }

    // TC: O(N)
    // SC: O(1)
    public static int majorityElementUsingBoyerVoting(int[] nums) {
        int count = 0;
        int candidate = 0;
        for(int num : nums) {
            if(count == 0) {
                candidate = num;
            }
            if(candidate == num) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return candidate;
    }
}
