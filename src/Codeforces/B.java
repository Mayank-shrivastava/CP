package Codeforces;
import java.util.*;
public class B {
    public static void main(String[] args) {
       int[] numsFirst = {3,4,10};
       int[] numsSecond = {1,4,8};
       int target = 5;
       int[] ans = solver(numsFirst, numsSecond, target);
       System.out.println(Arrays.toString(ans));
      
    }

    public static int[] solver(int[] numsFirst, int[] numsSecond, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0; i < numsFirst.length; i++) {
            if(map2.containsKey(target+numsFirst[i])) {
                ans[0] = i;
                ans[1] = map2.get(target+numsFirst[i]);
                return ans;
            }
            map2.put(numsSecond[i], i);
        }
        return ans;
    }
}
