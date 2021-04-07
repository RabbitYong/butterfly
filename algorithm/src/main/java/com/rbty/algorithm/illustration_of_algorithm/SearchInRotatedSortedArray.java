package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 33. 搜索旋转排序数组
 * @date 2021/4/7 9:13
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while(l <= r){
            int mid = (l + r)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]){
                //左侧有序
                if(target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                //右侧有序
                if (target > nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{5,6,7,8,1,3,4};
        int[] nums = new int[]{5,1,3};
        System.out.println(search(nums,3));
    }
}
