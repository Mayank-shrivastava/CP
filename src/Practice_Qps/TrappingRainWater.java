package Practice_Qps;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapWater(height));
    }

    public static int trapWater(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n-1] = height[n-1];
        // fill the left array
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        // fill the right array
        for(int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }


        int totalWater = 0;
        for(int i = 0; i < n; i++) {
            totalWater += (Math.min(left[i],right[i]) - height[i]);
        }
        return totalWater;
    }

    
}
