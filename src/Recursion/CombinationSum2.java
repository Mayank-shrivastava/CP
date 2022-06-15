package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5}; // {1, 1, 2, 5, 6, 7, 10}
        int target = 8;
        Arrays.sort(candidates);
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0,result, new ArrayList<>(), target, 0, candidates);
        return result;
    }

    private static void dfs(int start, List<List<Integer>> result,
                            List<Integer> currentList, int target, int currSum, int[] candidates) {
        //+ve base-case
        if(currSum == target) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // -ve base-case
        if(currSum > target) {
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1]) {
                continue; // skipping the duplicate combinations
            }
            currentList.add(candidates[i]);
            System.out.println(currentList);
            dfs(i+1,result, currentList, target, currSum+candidates[i], candidates);
            currentList.remove(currentList.size()-1);
        }
    }
}

// how to remove the duplicate combinations
