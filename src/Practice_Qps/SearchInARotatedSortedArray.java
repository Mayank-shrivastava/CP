package Practice_Qps;

public class SearchInARotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {11,12,15,18,2,5,6,8};
        int target = 6;
        int ans = solve(nums,target);
        System.out.println(ans);
    }

    public static int solve(int[] nums, int target) {
        int pivot = pivot(nums);
        if(pivot == -1) {
            return binarySearch(nums, target, 0, nums.length-1);
        }
        int left = binarySearch(nums, target, 0, pivot);
        if(left != -1) {
            return left;
        }
        return binarySearch(nums,target, pivot+1, nums.length-1);

    }

    public static int binarySearch(int[] nums, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int pivot(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            // actual positioning of mid(pivot)
            if(mid < hi && nums[mid] > nums[mid+1]) {
                return mid;
            }

            if(mid > lo && nums[mid] < nums[mid-1]) {
                return mid-1;
            }

            if(nums[mid] <= nums[lo]) {
                hi = mid-1; // go within the unsorted region
            } else {
                lo = mid+1;
            }
        }
        return -1;
    }
}
