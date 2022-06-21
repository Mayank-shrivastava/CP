package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subset2(nums));
    }

    public static List<List<Integer>> subset2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(int start, List<List<Integer>> result, List<Integer> currentList, int[] nums) {
        if(result.contains(currentList)) {
            return;
        }

        if(start >= nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        //backtrack(start+1, result, currentList, nums); // not choose nums[i]
        currentList.add(nums[start]);
        backtrack(start+1,result, currentList, nums); // choose nums[i]
        currentList.remove(currentList.size()-1);
        backtrack(start+1, result, currentList, nums); // not choose nums[i]
    }


    private static void dfs(int start, List<List<Integer>> result, List<Integer> currentList, int[] nums) {
        result.add(new ArrayList<>(currentList));
        for(int i = start; i < nums.length; i++) {
            if(i != start && nums[i] == nums[i-1]) {
                continue;
            }
            currentList.add(nums[i]);
            dfs(i+1, result, currentList, nums);
            currentList.remove(currentList.size() - 1);
        }
    }
}
