package com.rbty.algorithm.illustration_of_algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 记录滑动窗口最大值，此问题和 输出 MinStack最小值的问题类似，可维护一个递减辅助队列
 */
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[]{};
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int windowWidth = 3;
        for (int i : maxSlidingWindow(a, windowWidth)
        ) {
            System.out.println(i);
        }
    }
}
