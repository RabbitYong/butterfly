package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 74. 搜索二维矩阵
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * @date 2021/3/30 11:33
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target){
        int col = findCol(matrix,target);
        if (col < 0){
            return false;
        }
        return findRow(matrix,target,col);
    }

    private static int findCol(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int head=0,tail=m-1;
        while(head < tail){
            int mid = (tail - head + 1)/2 + head;
            if (target > matrix[mid][0]){
                head = mid;
            }else if (target < matrix[mid][0]){
                tail = mid-1;
            }else{
                return mid;
            }
        }
        return head;
    }
    private static boolean findRow(int[][] matrix, int target,int col){
        int m = matrix.length;
        int n = matrix[0].length;
        int head=0,tail=n-1;
        while(head <= tail){
            int mid = (tail - head + 1)/2 + head;
            if (target > matrix[col][mid]){
                head = mid+1;
            }else if (target < matrix[col][mid]){
                tail = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = {{1},{3}};
        int target = 4;
        System.out.println(searchMatrix(matrix,target));
    }
}
