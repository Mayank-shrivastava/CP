package Recursion;

public class Main {
    public static void main(String[] args) {
        printPermutations("abc", "");
    }

    public static void printPermutations(String str, String ans) {
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // capture the ith character
            String roq = str.substring(0,i) + str.substring(i+1); // rest of the question
            printPermutations(roq, ans + ch);
        }
    }
    
}
