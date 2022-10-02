package Practice_Qps;
import java.util.*;
public class Kdiff {
    public static void main(String[] args) {
        
    }

    public static int findPairs(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int val : map.keySet()) {
            if(k > 0 && map.containsKey(val) || k == 0 && map.get(val) > 1) {
                count++;
            }
        }
        return count;
    }
}
