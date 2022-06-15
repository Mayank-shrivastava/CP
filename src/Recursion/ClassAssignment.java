package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassAssignment {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0) {
            int n = scn.nextInt();
            // generate subsequence using a's and b's of n length with non-consecutive b's
            List<String> list = new ArrayList<>();
            subsequence(n,"",list,false);
            System.out.println("#"+n + " : " + list.size());
            //System.out.println(list);
        }
    }

    private static void subsequence(int n, String ans, List<String> list, boolean isBCalled) {
        if(ans.length() == n) {
            list.add(ans);
            return;
        }
        // 'a'
        subsequence(n, ans + "a", list, false);
        // 'b'
        if(!isBCalled) {
            subsequence(n, ans + "b", list, true);
        }
    }
}
