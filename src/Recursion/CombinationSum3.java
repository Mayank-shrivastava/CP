package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        int n = 4;
        int k = 1;
        System.out.println(combinationSum3(n,k));
    }

    public static List<List<Integer>> combinationSum3(int noOfCandidates, int target) {
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, result, new ArrayList<>(), noOfCandidates, target, 0, candidates);
        return result;
    }

    private static void dfs(int start, List<List<Integer>> result,
                            List<Integer> currentList, int noOfCandidates, int target, int currSum, int[] candidates) {
        if(currSum == target && currentList.size() == noOfCandidates) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        if(currSum > target || currentList.size() > noOfCandidates) {
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            dfs(i + 1, result, currentList, noOfCandidates, target, currSum + candidates[i], candidates);
            currentList.remove(currentList.size() - 1);
        }
    }
}
