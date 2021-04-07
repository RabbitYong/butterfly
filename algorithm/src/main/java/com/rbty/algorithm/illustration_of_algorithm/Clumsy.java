package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 1006. 笨阶乘
 * @date 2021/4/1 16:16
 */
public class Clumsy {
    public static int clumsy(int n){

        int loop = n/4;
        int left = n%4;
        if (n==1){
            return 1;
        }else if (n==2){
            return 2;
        }else if(n==3){
            return 6;
        }
        int solve = n*(n-1)/(n-2)+n-3;
        for (int i = 0; i < loop - 1; i++) {
            n = n-4;
            solve -= n*(n-1)/(n-2);
            solve += (n-3);
        }
        n=n-4;
        if (left == 1){
            solve = solve - n;
        }else if (left == 2){
            solve = solve - n*(n-1);
        }else if (left == 3){
            solve = solve - n*(n-1)/(n-2);
        }

        return solve;
    }

    public static void main(String[] args) {
        System.out.println(clumsy(10));
    }
}
