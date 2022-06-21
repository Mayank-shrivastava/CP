package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subset(nums));
    }

    public static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(int start, List<List<Integer>> result, List<Integer> currentList, int[] nums) {
        if(start >= nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        currentList.add(nums[start]);
        backtrack(start+1,result, currentList, nums); // choose nums[i]
        currentList.remove(currentList.size()-1);
        backtrack(start+1, result, currentList, nums); // not choose nums[i]
    }

    private static void dfs(int start, List<List<Integer>> result, List<Integer> currentList, int[] nums) {
        result.add(new ArrayList<>(currentList));
        for(int i = start; i < nums.length; i++) {
            currentList.add(nums[i]);
            dfs(i+1, result, currentList, nums);
            currentList.remove(currentList.size() - 1);
        }
    }
}
