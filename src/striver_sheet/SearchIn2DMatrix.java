package striver_sheet;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix,target));
    }

    // Matrix follows the following property:-
    //            1. Integers in each row are sorted from left to right.
    //            2. The first integer of each row is greater than the last integer of the previous row.
    // matrix[r][c] will be treated as the mid in binary search visualization
    public static boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length-1;
        while(r < matrix.length && c >= 0) {
            if(matrix[r][c] == target) {
                return true;
            }
            if(matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
