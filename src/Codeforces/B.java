package Codeforces;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t--> 0) {
            int n = scn.nextInt();
            int k = scn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) arr[i] = scn.nextInt();
            int x = solve(arr, n, k);
            System.out.println(x);
        }
    }

    public static int solve(int[] arr, int n, int k) {
        int count = 0;
        for(int i = 1; i < n-1; i++) {
            if(arr[i] > arr[i-1] + arr[i+1]) {
                count++;
            }
        }
        if(k==1) {
            return (n-1)/2;
        } else {
            return count;
        }
    }
}
