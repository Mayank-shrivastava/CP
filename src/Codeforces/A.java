package Codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) arr[i] = scn.nextInt();
            int x = solve(arr, n);
            System.out.println(x);
        }
    }

    public static int solve(int[] arr, int n) {
        List<Integer> list = new ArrayList<>();
        for(int val : arr) list.add(val);
        for(int i = 0; i < n; i++) {
            int xpos = list.remove(i);
            int xor = 0;
            for(int j = 0; j < list.size(); j++) {
                xor ^= list.get(j);
            }
            //System.out.println(xpos + " " + xor);
            //System.out.println(list);
            if(xor == xpos) return xpos;
            else {
                list.add(i, xpos);
            }
        }
        return -1;
    }
}
