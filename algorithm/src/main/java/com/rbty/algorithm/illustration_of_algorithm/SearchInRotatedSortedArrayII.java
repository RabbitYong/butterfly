package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 81. 搜索旋转排序数组 II
 * @date 2021/4/7 10:28
 */
public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[r] == nums[mid]){
                l++;
                r--;
            }else if (nums[l] <= nums[mid]){
                //左侧有序
                if(target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else{
                //右侧有序
                if (target <= nums[r] && target > nums[mid]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,0,1,1,1};
        System.out.println(search(arr,0));

    }
}
