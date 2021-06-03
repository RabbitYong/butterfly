package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 744. 寻找比目标字母大的最小字母
 * @date 2021/4/8 15:27
 */
public class FindSmallestLetterGreaterThanTarget {
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left < right){
            if (letters[left] > target || letters[right] < target) {
                return letters[left];
            }
            int mid = ((right - left) >> 1) + left;
            if (letters[mid] <= target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return letters[left];
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'a','b'};
        char target = 'z';
        System.out.println(nextGreatestLetter(letters,target));
    }
}
