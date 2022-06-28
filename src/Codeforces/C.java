package Codeforces;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0) {
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) arr[i] = scn.nextInt();
            boolean response = solve(arr, n);
            if(response) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean solve(int[] arr, int n) {
        boolean ans = true;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    sum += arr[i] + arr[j] + arr[k];
                    if(Arrays.binarySearch(arr, sum) == -1) {
                        ans = false;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}