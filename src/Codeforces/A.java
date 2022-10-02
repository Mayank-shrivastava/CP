package Codeforces;

import java.util.*;
public class A {
    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int numberOfMoves = scn.nextInt(); 
      int[] moves = new int[numberOfMoves];
      for(int i = 0; i < numberOfMoves; i++) {
        moves[i] = scn.nextInt();
      }
      solver(n, "", moves, numberOfMoves);
    }

    public static void solver(int n, String ans, int[] moves, int numberOfMoves) {
        if(n < 0) {
            return;
        }

        if(n == 0) {
            System.out.println(ans);
            return;
        }
       
        for(int i = 0; i < numberOfMoves; i++) {
            solver(n-moves[i], ans + moves[i], moves, numberOfMoves);
        }
    }
}


 