package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/4/19 15:45
 */
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {

            }
        }
        return false;
    }

    public static boolean search(){
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'a','b','c','e'},
                {'s','f','c','s'},
                {'a','d','e','e'}
        };
        String target = "abcced";
        exist(chars,target);
    }
}
