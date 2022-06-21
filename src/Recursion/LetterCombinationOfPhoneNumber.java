package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        String s = "";
        System.out.println(letterCombinations(s));
    }

    public static List<String> letterCombinations(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() == 0) {
            return result;
        }

        String[] keypad = {",","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        helper(0, result, new StringBuilder(), s, keypad);
        return result;
    }

    private static void helper(int start, List<String> result, StringBuilder output, String s, String[] keypad) {
        if(start == s.length()) {
            result.add(output.toString());
            return;
        }
        int number = s.charAt(start)-'0';
        //System.out.println(number);
        String value = keypad[number-1];

        for(int i = 0; i < value.length(); i++) {
            output.append(value.charAt(i));
            helper(start+1, result, output, s, keypad);
            output.setLength(output.length()-1);
        }
    }
}
