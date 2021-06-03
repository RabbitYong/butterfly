package com.rbty.algorithm.illustration_of_algorithm;

import cn.hutool.core.lang.Console;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 二叉树中序遍历
 * @date 2021/4/13 10:00
 */
public class BinaryTreeInorderTraversal {
    /** 
     * @description: 递归法 
     * @param: [root] 
     * @return: List<Integer>
     */
    public static List<Integer> inorderTraversalRecursive(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }
    public static void inorder(TreeNode node,List<Integer> list){
        if (node != null){
            inorder(node.left, list);
            list.add(node.val);
            inorder(node.right,list);
        }
    }

    /**
     * @description: 迭代法
     * @param: [root]
     * @return: java.util.List<java.lang.Integer>
     */
    public static List<Integer> inorderTraversalIteration(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()){
            while(root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
    
    /** 
     * @description: Morris 中序遍历 
     * @param: [args] 
     * @return: void
     */
    public static List<Integer> inorderTraversalMorris(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode12 = new TreeNode(12);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode14 = new TreeNode(14);
        TreeNode treeNode15 = new TreeNode(15);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        treeNode5.left = treeNode10;
        treeNode5.right = treeNode11;
        treeNode6.left = treeNode12;
        treeNode6.right = treeNode13;
        treeNode7.left = treeNode14;
        treeNode7.right = treeNode15;

        Console.log(inorderTraversalMorris(treeNode1));
    }
}
