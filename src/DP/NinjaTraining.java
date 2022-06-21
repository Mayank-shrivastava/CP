package DP;

public class NinjaTraining {
    public static void main(String[] args) {
        int n = 3;
        int[][] points = {{10,40,70},{20,50,80},{30,60,90}};
        System.out.println(ninjaTraining(n-1,points));
    }

    public static int ninjaTraining(int n, int[][] points) {
        return f(n, points, 3);
    }

    private static int f(int n, int[][] points, int lastTask) {
        if(n == 0) {
            int maxi = 0;
            for(int i = 0; i < 3; i++) {
                if(i != lastTask) {
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return maxi;
        }

        int maxi = 0;
        for(int i = 0; i <= 2; i++) {
            if(i != lastTask) {
                maxi = Math.max(maxi,points[n][i] + f(n-1, points, i));
            }
        }
        return maxi;
    }
}
