package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        // similar bactracking appraoch
        List<List<Integer>> result = new ArrayList<>();
        permuteSolver(0, result, new ArrayList<>(), new boolean[nums.length], nums);
        return result;
    }

    private static void permuteSolver(int start, List<List<Integer>> result, List<Integer> currentList, boolean[] visited, int[] nums) {
        if(start >= nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                currentList.add(nums[i]);
                permuteSolver(start+1, result, currentList, visited, nums);
                currentList.remove(currentList.size()-1);
                visited[i] = false;
            }
        }
    }
}
