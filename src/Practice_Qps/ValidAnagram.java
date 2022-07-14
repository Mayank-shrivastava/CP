package Practice_Qps;
import java.util.*;
public class ValidAnagram {
    public static void main(String[] args) {
        
    }

    // using sorting
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        Arrays.sort(sch);
        Arrays.sort(tch);
        for(int i = 0; i < s.length(); i++) {
            if(sch[i] != tch[i]) return false;
        }
        return true;
    }

    // using hashmap

    public static boolean isAnagramUsingMap(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        int count = map.size();
        for(char ch : t.toCharArray()) {
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0) {
                    count-=1;
                }
            }
            
        }

        return count==0;
    }
}
