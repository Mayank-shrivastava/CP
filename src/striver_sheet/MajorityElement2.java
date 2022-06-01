package striver_sheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] nums = {7,7,5,2,1,5,6,6,6,6,7,7,7,6,6,7};
//        List<Integer> list = majorityElement(nums);
//        System.out.println(list);

        List<Integer> list = majorityElementUsingVotingAlgo(nums);
        System.out.println(list);
    }

    public static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()) {
            if(map.get(key) > nums.length/3) {
                list.add(key);
            }
        }
        return list;
    }

    public static List<Integer> majorityElementUsingVotingAlgo(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int num1 = -1;
        int num2 = -1;
        int c1 = 0;
        int c2 = 0;
        for(int num : nums) {
            if(num == num1) {
                c1++;
            } else if(num == num2) {
                c2++;
            } else if(c1 == 0) {
                num1 = num;
                c1++;
            } else if(c2 == 0) {
                num2 = num;
                c2++;
            }  else {
                c1--;
                c2--;
            }
        }
        int count1 = 0;
        int count2 = 0;
        for(int num : nums) {
            if(c1 > 0 && num1 == num) {
                count1++;
            }
            if(c2 > 0 && num2 == num) {
                count2++;
            }
        }

        if(count1 > nums.length/3) {
            list.add(num1);
        }
        if(count2 > nums.length/3) {
            list.add(num2);
        }
        return list;
    }
}
