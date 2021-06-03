package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/8 16:50
 */
public class FindMinimumInRotatedSortedArrayII {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (nums[left] < nums[right]){
                return nums[left];
            }else {
                if (nums[left] == nums[mid] && nums[right] == nums[mid]){
                    left = left + 1;
                    right = right - 1;
                }else if (nums[left] <= nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,0,2};
        //int[] nums = new int[]{3,1,2};
        System.out.println(findMin(nums));
    }
}
