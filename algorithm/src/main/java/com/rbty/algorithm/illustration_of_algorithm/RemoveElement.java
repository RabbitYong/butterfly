package com.rbty.algorithm.illustration_of_algorithm;

import cn.hutool.core.lang.Console;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 27. 移除元素
 * @date 2021/4/19 10:09
 */
public class RemoveElement {
    public static int removeElement(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left<=right){
            if (arr[left] == target){
                arr[left] = arr[right];
                right --;
            }else {
                left ++;
            }
        }
        Console.log(arr);

        return left;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4,3};
        int target = 3;
        System.out.println(removeElement(arr,target));
    }
}
