package Recursion;
import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String str = "catsandog";
        String[] arr = {"cats","dog","and","sand","cat"};
        List<String> wordDist = Arrays.asList(arr);
        System.out.println(wordBreak(str, wordDist));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap<>());
    }

    private static boolean helper(String s, List<String> wordDict, HashMap<String, Boolean> map) {
        if(wordDict.contains(s)) return true;
        if(map.containsKey(s)) return map.get(s);
        for(int i = 1; i <= s.length(); i++) {
            // partition for every index
            String subStr = s.substring(0,i);
            if(wordDict.contains(subStr) && helper(s.substring(i),wordDict, map)) {
                map.put(subStr, true);
                return true;
            }
        }
        map.put(s,false);
        return false;
    }
}
