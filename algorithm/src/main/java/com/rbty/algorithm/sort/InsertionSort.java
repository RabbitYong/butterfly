package com.rbty.algorithm.sort;

import cn.hutool.core.lang.Console;
import org.testng.annotations.Test;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/12 17:01
 */
public class InsertionSort {
    public static int[] sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j]<arr[j-1]){
                    Sorts.swap(arr,j,j-1);
                }else{
                    break;
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
