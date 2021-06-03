package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 783. 二叉搜索树节点最小距离
 * @date 2021/4/13 9:03
 */


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description: Definition for a binary tree node.
 * @author tuzhiyong
 * @date 2021/4/13 9:05
 * @version 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class MinimumDistanceBetweenBstNodes {
    static int pre;
    static int min;
    public static int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return min;
    }

    public static void dfs(TreeNode node){
        if (node == null){
            return;
        }
        dfs(node.left);

        if (pre != -1) {
            min = Math.min(min, node.val - pre);
        }
        pre = node.val;
        dfs(node.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(90);
        TreeNode treeNode2 = new TreeNode(69);
        TreeNode treeNode3 = new TreeNode(49);
        TreeNode treeNode4 = new TreeNode(89);
        TreeNode treeNode5 = new TreeNode(52);

        treeNode1.left = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode3.right = treeNode5;

        System.out.println(minDiffInBST(treeNode1));
    }
}


