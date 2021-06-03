package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/15 10:02
 */
public class HouseRobberII {
    public static int rob(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums,0, nums.length-2),rob(nums,1, nums.length-1));
    }
    public static  int rob(int[] nums, int start, int end){
        int first = nums[start];
        int second = Math.max(first,nums[start+1]);

        for (int i = start+2; i <= end; i++) {
            int temp = Math.max(nums[i]+first,second);
            first = second;
            second = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,6,3,7,10};
        System.out.println(rob(nums));
    }
}
