package striver_sheet;
import java.util.*;
public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {1,0,1},{1,1,1}};
        //setZeros(matrix);
        setZeroUsingWithoutSpace(matrix);
        for(int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //Brute-force solution
    //works well only if the elements of the array are positive
    public static void setZeros(int[][] matrix) {
        // traverse over the matrix
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0) {
                    // change row and col to zeros
                    // rows
                    for(int j = 0; j < matrix[row].length; j++) {
                        if(matrix[row][j] != 0) matrix[row][j] = Integer.MIN_VALUE;
                    }

                    // cols
                    for(int i = 0; i < matrix.length; i++) {
                        if(matrix[i][col] != 0) matrix[i][col] = Integer.MIN_VALUE;
                    }
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == Integer.MIN_VALUE) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // using extra space
    public static void setMatrixUsingExtraSpace(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        // traverse over the matrix
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                // store in rows and cols if matrix[i][j] == 0;
                if(matrix[i][j] == 0) {
                    rows.add(i); // add ith row
                    cols.add(j); // add jth col
                }
            }
        }

        // next iteration over matrix
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //without using space
    public static void setZeroUsingWithoutSpace(int[][] matrix) {
        boolean isRow = false;
        boolean isCol = false;
        int r =  matrix.length;
        int c =  matrix[0].length;

        // check for first col that it contains zero or not
        for(int i = 0; i < r; i++) {
            if(matrix[i][0] == 0) isCol = true;
        }
        // check for first row
        for(int j = 0; j < c; j++) {
            if(matrix[0][j] == 0) isRow = true;
        }

        // traverse over the matrix check if matrix[i][j]==0 mark matrix[i][0] = 0 and matrix[0][j]=0
        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // marking of dummy done now look for dummy and set remaining positions to zeros
        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // look for first row
        if(isRow) {
            for(int j = 0; j < c; j++) matrix[0][j] = 0;
        }

        // look for first col
        if(isCol) {
            for(int i = 0; i < r; i++) matrix[i][0] = 0;
        }
    }
}
