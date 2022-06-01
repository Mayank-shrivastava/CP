package striver_sheet;

import java.util.HashSet;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicate(arr));
        System.out.println(findDuplicateWithoutUsingExtraSpace(arr));
    }

    // using extra space
    public static int findDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : arr) {
            if(!set.contains(ele)) {
                set.add(ele);
            } else {
                return ele;
            }
        }
        return -1;
    }

    // without using extra space (cyclic sort or swap sort algorithm)
    public static int findDuplicateWithoutUsingExtraSpace(int[] arr) {
        cyclicSort(arr);
        return arr[arr.length-1];
    }

    private static void cyclicSort(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }
    }
}

