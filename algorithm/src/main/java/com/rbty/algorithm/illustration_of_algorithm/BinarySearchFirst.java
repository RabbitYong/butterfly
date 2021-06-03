package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 单调不减序列,寻找目标值第一次出现的位置
 * @date 2021/4/8 10:22
 */
public class BinarySearchFirst {
    public static int binarySearchFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right){
            int mid = (left + right) >> 1;
            if (arr[mid] >= target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        if (left == target){
            return left;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,3,5};
        int target = 3;
        System.out.println(binarySearchFirst(arr,target));
    }
}
