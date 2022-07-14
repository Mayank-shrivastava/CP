package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));

    }

    private static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, result, new ArrayList<>(), s);
        return result;
    }

    private static void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
        // base-case
        if(start >= s.length()) {
            result.add(new ArrayList<>(currentList));
        }
        for(int end = start; end < s.length(); end++) {
            if(isPalindrome(s, start, end)) {
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, result, currentList, s);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
