package Practice_Qps;

public class SearchInARotatedSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        boolean ans = search(nums,target);
        System.out.println(ans);
    }

    public static boolean search(int[] nums, int target) {
        int pivot = pivot(nums);
        if(pivot == -1) {
            return binarySearch(nums, target, 0, nums.length-1);
        }
        boolean left = binarySearch(nums, target, 0, pivot);
        if(left) {
            return true;
        }
        return binarySearch(nums, target, pivot+1, nums.length - 1);
    }

    public static boolean binarySearch(int[] nums, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return true;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static int pivot(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid < end && nums[mid] > nums[mid+1]) {
                return mid;
            }
            if(mid > start && nums[mid] < nums[mid-1]) {
                return mid-1;
            }

            if(nums[mid] <= nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
