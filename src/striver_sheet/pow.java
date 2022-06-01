package striver_sheet;

public class pow {
    public static void main(String[] args) {
        double x = 2;
        long n = 7;
        System.out.println(myPowRecursive(x,n));
        System.out.println(myRecIterative(x,n));
    }

    public static double myPowRecursive(double x, long n) {
        // handling the negatives
        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        if(n == 0) {
            return 1;
        }
        if(x == 1) {
            return 1;
        }
        if(n == 1) {
            return x;
        }
        double ans = 1;
        if(n % 2 == 0) {
            ans  = ans * myPowRecursive(x*x,n/2);
        } else {
            ans = ans * x * myPowRecursive(x*x,n/2);
        }
        return ans;
    }

    public static double myRecIterative(double x, long n) {
        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        double res = 1;
        double currResult = x;
        for(long i = n; i > 0; i /= 2) {
            if(i % 2 == 1) {
                res = currResult * res;
            }
            currResult = currResult * currResult;
        }
        return res;
    }
}
