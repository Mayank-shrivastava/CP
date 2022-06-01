package Practice_Qps;

import java.util.*;
public class PairOfTopics {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++) a[i] = scn.nextInt();
       // System.out.println(Arrays.toString(a));
        for(int i = 0; i < n; i++) b[i] = scn.nextInt();
        //System.out.println(Arrays.toString(b));
        int[] c = new int[n];
        for(int i = 0; i < n; i++) c[i] = a[i] - b[i];
        //System.out.println(Arrays.toString(c));
        Arrays.sort(c);
        //System.out.println(Arrays.toString(c));
        long ans = 0;
        for(int i = 0; i < n; i++) {
            if(c[i] <= 0) continue;
            // find smallest j such cj < -ci
            int pos = lowerBound(c, 0, n - 1, -c[i] + 1);
            ans += i - pos;
        }
        System.out.println(ans);
    }

    public static int lowerBound(int[] nums, int start, int end, int target) {
        int ans = -1;
        while(start <= end) {
            int mid = (start + end)/ 2;
            if(nums[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
