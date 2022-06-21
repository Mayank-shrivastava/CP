package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintPermutationOfString {
    public static void main(String[] args) {
        String str = "abc";
        printPermutation(str, "");
        System.out.println(getPermutation(str));
    }

    private static void printPermutation(String str, String ans) {
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            // capture the ith character
            char ch = str.charAt(i);
            // get the string without ith character
            String ros = str.substring(0,i) + str.substring(i+1);

            printPermutation(ros, ans + ch);
        }
    }

    private static List<String> getPermutation(String str) {
        if(str.length() == 0) {
            List<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);
        List<String> result = new ArrayList<>();
        List<String> rr = getPermutation(ros);
        for(String rrs : rr) {
            for(int i = 0; i <= rrs.length(); i++) {
                String val = rrs.substring(0,i) + ch + rrs.substring(i);
                result.add(val);
            }
        }
        return result;
    }
}
