package Recursion;

import java.util.*;

public class NQueens1 {
    public static void main(String[] args) {
        List<List<String>> ans = solveQueens(4);
        System.out.println(ans);
    }

    public static List<List<String>> solveQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] ch : board) Arrays.fill(ch, '.');
        List<List<String>> result = new ArrayList<>();
        solve(0, board, n,result);
        return result;
    }

    

    private static void solve(int col,char[][] board, int n, List<List<String>> result) {
        // base-case
        if(col == n) {
            result.add(new ArrayList<>(construct(board)));
            return;
        }

        for(int row = 0; row < n; row++) {
            if(isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, n, result);
                board[row][col] = '.'; // backtracking step
            }

        }
    }


    private static boolean isSafe(int row, int col, char[][] board, int n) {
        int dr = row;
        int dc = col;

        // row-- and col--
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        // revive the row and col values
        row = dr; 
        col = dc;

        // col--
        while(col >= 0) {
            if(board[row][col] == 'Q') return false;
            col--;
        }

        // revive values;
        row = dr;
        col = dc;

        // row++ col--
        while(row < n && col >= 0) {
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }


    private static List<String> construct(char[][] board) {
        List<String> ans = new ArrayList<>();
        for(char[] row : board) {
            ans.add(new String(row));
        }
        return ans;
    }
}
