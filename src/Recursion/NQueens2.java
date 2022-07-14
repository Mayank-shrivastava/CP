package Recursion;
import java.util.*;
public class NQueens2 {
    public static void main(String[] args){
        System.out.println(totalQueens(4));
    }
    
    public static int totalQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] ch : board) Arrays.fill(ch,'.');
        return solve(0, board,n);
    }

    private static int solve(int col, char[][] board, int n) {
        if(col == n) return 1;
        int count = 0;
        for(int row = 0; row < n; row++) {
            if(isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                count += solve(col+1, board, n);
                board[row][col] = '.';
            }
        }
        return count;
    }

    private static boolean isSafe(char[][] board, int row, int col, int n) {
        int dr = row;
        int dc = col;
        // row-- col--
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = dr;
        col = dc;
        // col--
        while(col >= 0) {
            if(board[row][col] == 'Q') return false;
            col--;
        }

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
}
