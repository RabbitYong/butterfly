package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 263. 丑数
 * @date 2021/4/7 11:30
 */
public class UglyNumber {
    public boolean isUgly(int n) {
        if (n < 1){
            return false;
        }

        while (n % 2 == 0){
            n /= 2;
        }
        while (n % 3 == 0){
            n /= 3;
        }
        while (n % 5 == 0){
            n /= 5;
        }

        return n==1;
    }
}
