package com.rbty.algorithm.sort;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/12 17:08
 */
public class Sorts {
    public static int[] swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return arr;
    }
}
