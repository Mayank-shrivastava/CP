package pattern_qps;

public class q9 {
    public static void main(String[] args) {
        p14(5);
        
    }

    public static void p9(int n) {
        for(int i = n; i >= 1; i--) {
            for(int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void p10(int n) {
        // full pyramid for n rows
        for(int i = 1; i <= n; i++) {
            for(int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // inverted full pyramid for n-1 rows
        for(int i = n-1; i >= 1; i--) {
            for(int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void p11(int n) {
        // right triangle star pattern with n rows
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // inverted right triangle star pattern with n-1 rows
        for(int i = n-1; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void p12(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j<=i; j++) {
                if((i+j) % 2 == 0) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

    public static void p13(int n) {
        // first half
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for(int j = i*2; j < n*2; j++) {
                System.out.print(" ");
            }
            for(int p = i; p >= 1; p--) {
                System.out.print(p);
            }
            System.out.println();
        }
    }

    public static void p14(int n) {
        int number = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }

    public static void p22(int n) {
        
    }
}
