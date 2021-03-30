package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 191. 位1的个数
 * n&(n-1) 即 将 n的末位的 1 变为0
 * @date 2021/3/26 10:12
 */
public class HammingWeight {
    public static int hammingWeight(int num) {
        int result = 0;
        while (num != 0) {
            num = num & (num - 1);
            result++;
        }
        return result;
    }
}
