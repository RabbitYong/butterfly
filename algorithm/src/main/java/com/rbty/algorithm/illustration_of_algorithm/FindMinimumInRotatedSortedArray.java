package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 154. 寻找旋转排序数组中的最小值 II,允许重复
 * @date 2021/4/8 9:08
 */
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (nums[left] < nums[right]){
                return nums[left];
            }else {
                if (nums[left] <= nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        //int[] nums = new int[]{3,1,2};
        System.out.println(findMin(nums));
    }
}
