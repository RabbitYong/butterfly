package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/6 9:33
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] arr){
        int slow = 1;
        int fast = 1;
        while(fast < arr.length){
            if (arr[fast] != arr[fast-1]){
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
