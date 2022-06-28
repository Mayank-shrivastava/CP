package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1};
        System.out.println(longestBitonicSubsequence(arr));
    }

    public static int longestBitonicSubsequence(int[] arr) {
        int[] lis1 = new int[arr.length];
        Arrays.fill(lis1,1);
        for(int i = 0; i < arr.length; i++) {
            for(int prev = 0; prev < i; prev++) {
                if(arr[i] > arr[prev]) {
                    lis1[i] = Math.max(lis1[i],1 + lis1[prev]);
                }
            }
        }
        int[] lis2 = new int[arr.length];
        Arrays.fill(lis2,1);
        for(int i = arr.length-1; i >= 0; i--) {
            for(int prev = arr.length-1; prev >= i; prev--) {
                if(arr[i] > arr[prev]) {
                    lis2[i] = Math.max(lis2[i],1 + lis2[prev]);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            list.add(lis1[i] + lis2[i]);
        }

        return Collections.max(list);
    }
}
