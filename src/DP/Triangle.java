package DP;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        return solve(triangle, 0, 0);
    }

    public static int solve(List<List<Integer>> triangle, int cr, int cc) {
        if(cr == triangle.size()-1 && cc == triangle.get(0).size()-1) {
            return triangle.get(cr).get(cc);
        }

        if(cr > triangle.size()-1 || cc > triangle.get(0).size()-1) {
            return Integer.MIN_VALUE;
        }

        int oneMove = solve(triangle, cr+1, cc);
        int secondMove = solve(triangle, cr+1, cc+1);
        return Math.min(oneMove, secondMove);
    }
}
