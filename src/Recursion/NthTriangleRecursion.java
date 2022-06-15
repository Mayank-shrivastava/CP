package Recursion;

import java.util.Scanner;

public class NthTriangleRecursion {
    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        int n = scn.nextInt();
        int ans = solve(n);
        System.out.println(ans);
    }

    private static int solve(int n) {
        if(n == 1) {
            return 1;
        }
        int ans = n;
        ans = ans + solve(n-1);
        return ans;
    }
}
