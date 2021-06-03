package com.rbty.algorithm.sort;

import cn.hutool.core.lang.Console;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 冒泡排序，比较交换
 * @date 2021/4/12 16:30
 */
public class BubbleSort {
    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        Console.log(arr);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,6,7,3,1};
        sort(arr);
    }
}
