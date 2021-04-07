package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 80. 删除有序数组中的重复项 II
 * @date 2021/4/6 9:10
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] arr) {
        int slow=2,fast=2;
        while (fast < arr.length){
            if (arr[fast] != arr[slow-2]){
                arr[slow] = arr[fast];
                slow ++;
            }
            fast ++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,3,3,4,4,5,6,6,6,7,7,9,9,9};
        System.out.println(removeDuplicates(arr));
    }
}
