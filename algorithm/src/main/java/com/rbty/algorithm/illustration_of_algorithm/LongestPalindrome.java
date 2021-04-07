package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/3/30 16:45
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                if (l == 0){
                    dp[l][i] = true;
                }else {
                    boolean b = s.charAt(i) == s.charAt(i + l);
                    if (l == 1){
                        dp[l][i] = b;
                    }else{
                        dp[l][i] = dp[l-2][i+1] && b;
                    }
                }
                if (dp[l][i] && l+1 > ans.length()){
                    ans = s.substring(i,i+l+1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
    }
}
