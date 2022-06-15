package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void dfs(int start, List<List<Integer>> result, List<Integer> currentList,
                            int[] candidates, int target, int currSum) {
        // +ve base-case
        if(currSum == target) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // -ve base-case
        if(currSum > target) {
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            dfs(i ,result, currentList,candidates, target, currSum + candidates[i]);
            currentList.remove(currentList.size() - 1);
        }
    }
}
