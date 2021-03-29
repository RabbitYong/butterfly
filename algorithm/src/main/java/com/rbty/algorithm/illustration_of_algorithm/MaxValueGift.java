package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: Offer 47 二维数组 最大路径
 * @date 2021/3/26 16:05
 */
public class MaxValueGift {
    public static int maxValue(int[][] grid) {
        if (grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i==0 && j==0){

                }else if (i==0){
                    grid[i][j] += grid[i][j-1];
                }else if (j==0){
                    grid[i][j] += grid[i-1][j];
                }else{
                    grid[i][j] += Math.max(grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        return grid[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(maxValue(grid));
    }
}
