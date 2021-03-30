package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author rbty
 * @version 1.0
 * @description: TODO
 * @date 2021/3/23 16:51
 */
public class TranslateNum {
    public static int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        String numStr = String.valueOf(num);
        int[] dp = new int[numStr.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            String s = String.valueOf(numStr.charAt(i - 2));
            int last = Integer.parseInt(s);
            int sum = Integer.parseInt(s + String.valueOf(numStr.charAt(i - 1)));

            if (last > 0 && sum < 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int num = 12257;
        System.out.println(translateNum(num));
    }
}
