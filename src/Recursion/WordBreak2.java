package Recursion;

import java.util.*;

public class WordBreak2 {
    public static void main(String[] args) {
        
        String str = "catsanddog";
        String[] arr = {"cat","cats","and","sand","dog"};
        List<String> wordDict = Arrays.asList(arr);
        System.out.println(wordBreak(str, wordDict));
    }
 
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        dfs(0, s, wordDict, result, new ArrayList<>());
        return result;
    }


    private static void dfs(int start, String s, List<String> wordDict, List<String> result, List<String> current) {
        if(start >= s.length()) {
            result.add(String.join(" ", current));
            return;
        }

        for(int i = start+1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if(wordDict.contains(str)) {
                current.add(str);
                dfs(i, s, wordDict, result, current);
                current.remove(current.size() - 1);
            }
        }
    }    
}
