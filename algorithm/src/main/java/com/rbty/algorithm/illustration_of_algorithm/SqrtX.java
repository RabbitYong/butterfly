package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 69. x 的平方根
 * @date 2021/4/8 14:04
 */
public class SqrtX {
    /**
     * @description: 二分法求平方根
     * @param: [x]
     * @return: int
     */
    public static int sqrt(int x){
        int left = 0;
        int right = x;
        int ans = 0;
        while (left <= right){
            int mid = ((right - left) >> 1) + left;
            if (mid*mid < x){
                left = mid + 1;
                ans = mid;
            }else if (mid*mid > x){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return ans;
    }

    public static int sqrtNewton(int x){
        if (x == 0) {
            return 0;
        }
        double x0 = x;
        while(true){
            double xi = 0.5*(x0 + x/x0);
            if (Math.abs(xi - x0) < Math.pow(10,-7)){
                return (int)xi;
            }
            x0 = xi;
        }
    }

    public static void main(String[] args) {
        System.out.println(sqrtNewton(0));
    }
}
