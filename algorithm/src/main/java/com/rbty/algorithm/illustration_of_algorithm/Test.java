package com.rbty.algorithm.illustration_of_algorithm;

import cn.hutool.core.lang.Console;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/5/10 10:13
 */
public class Test {
    public static boolean canReach(int[] arr, int start) {
        int[] flag = new int[arr.length];
        if (arr[start] == 0){
            return true;
        }
        flag[start] = 1;
        Deque<Integer> deque = new LinkedList<>();
        deque.add(start);
        while(!deque.isEmpty()){
            Integer current = deque.pop();
            int left = current - arr[current];
            int right = current + arr[current];
            if (left>=0 && left<arr.length && flag[left]==0){
                if (arr[left] == 0){
                    return true;
                }
                deque.add(left);
                flag[left] = 1;
            }
            if (right>=0 && right<arr.length && flag[right]==0){
                if (arr[right] == 0){
                    return true;
                }
                deque.add(right);
                flag[right] = 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,3,0,3,1,2};
        int start = 5;
        System.out.println(canReach(arr,start));
    }
}
