package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/8 11:29
 */
public class GuessNumberHigherOrLower {
    int target;

    public GuessNumberHigherOrLower(int target) {
        this.target = target;
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right){
            int mid = ((right - left) >> 1) + left;
            if (guess(mid) == 0){
                return mid;
            }else if (guess(mid) == 1){
                right = mid - 1;
            }else if (guess(mid) == -1){
                left = mid + 1;
            }
        }
        return left;
    }

    public int guess(int number){
        if (number > target){
            return 1;
        }else if (number < target){
            return -1;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower guessNumberHigherOrLower = new GuessNumberHigherOrLower(6);
        int ans = guessNumberHigherOrLower.guessNumber(10);
        System.out.println(ans);
    }
}
