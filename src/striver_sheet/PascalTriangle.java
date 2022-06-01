package striver_sheet;
import java.util.*;
public class PascalTriangle {
    public static void main(String[] args) {
        int nums = 5;
        List<List<Integer>> ans = generate(5);
        for(List<Integer> n : ans) {
            System.out.println(n);
        }
    }

    public static List<List<Integer>> generate(int nums) {
        if (nums == 0) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j==0 || j == i) temp.add(1);
                else {
                    temp.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
                }
            }
            ans.add(temp);
        }

        return ans;
    }
}
