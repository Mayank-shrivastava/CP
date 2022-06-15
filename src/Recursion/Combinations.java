package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 1;
        int k = 1;
        System.out.println(combine(n,k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> candidates = new ArrayList<>();
        for(int i = 1; i <= n; i++) candidates.add(i);
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, result, new ArrayList<>(), k, candidates);
        return result;
    }

    private static void dfs(int start, List<List<Integer>> result, List<Integer> currentList, int noOfCandidates, List<Integer> candidates) {
        // +ve base-case
        if(currentList.size() == noOfCandidates) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for(int i = start; i < candidates.size(); i++) {
            currentList.add(candidates.get(i));
            dfs(i+1, result, currentList,noOfCandidates,candidates);
            currentList.remove(currentList.size() - 1);
        }
    }
}
