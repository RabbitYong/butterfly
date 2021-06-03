package com.rbty.algorithm.illustration_of_algorithm;

import cn.hutool.core.lang.Console;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/16 9:26
 */
public class ScrambleString {
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;           //当天无股票
        dp[0][1] = -prices[0];  //当天有股票
        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        Console.log(maxProfit(arr));
    }
    /*publis static Boolean isScramble(String s1, String s2){
        int length = s1.length();
        if (s2.length() != length){
            return false;
        }
        for (int i = 0; i < length; i++) {

        }
    }*/
}
