package com.rbty.algorithm.sort;

import cn.hutool.core.lang.Console;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 選擇排序
 * @date 2021/4/12 16:45
 */
public class SelectionSort {
    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        Console.log(arr);
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,6,7,3,1};
        sort(arr);
    }
}
