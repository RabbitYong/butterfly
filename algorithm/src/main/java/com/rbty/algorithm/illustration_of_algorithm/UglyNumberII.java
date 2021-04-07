package com.rbty.algorithm.illustration_of_algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 264. 丑数 II
 * n 不超过1690。
 * @date 2021/4/7 11:34
 */
public class UglyNumberII {
    /**
     * @description: 优先队列 + HashSet
     */
    public static int nthUglyNumber1(int n) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        priorityQueue.add(1);
        hashSet.add(1);

        int[] arr = new int[]{2,3,5};
        for (int i = 1; i < 1691; i++) {
            int current = priorityQueue.poll();
            list.add(current);
            for (int j = 0; j < arr.length; j++) {
                int nextUgly = arr[j] * current;
                if (!hashSet.contains(nextUgly)){
                    priorityQueue.add(nextUgly);
                    hashSet.add(nextUgly);
                }
            }
        }
        return list.get(n-1);
    }

    /** 
     * @description:  dp + 三指针
     * @param: [n] 
     * @return: int
     */
    public static int nthUglyNumber2(int n) {
        int p2=0 ,p3=0 ,p5=0;
        int[] dp = new int[1690];
        dp[0] = 1;
        for (int i = 1; i < 1690; i++) {
            int next = Math.min(Math.min(dp[p2]*2,dp[p3]*3),dp[p5]*5);
            dp[i] = next;
            if (next == dp[p2]*2){
                p2 ++ ;
            }
            if (next == dp[p3]*3){
                p3 ++ ;
            }
            if (next == dp[p5]*5){
                p5 ++ ;
            }
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber2(10));
    }
}
