package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: 83. 删除排序链表中的重复元素
 * @date 2021/3/26 9:49
 */
public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode nodeA = head;
        while (nodeA != null) {
            ListNode nextNode = nodeA.next;
            while (nextNode != null && nextNode.val == nodeA.val) {
                nextNode = nextNode.next;
            }
            nodeA.next = nextNode;
            nodeA = nextNode;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = deleteDuplicates(node1);
        System.out.println(head);
    }
}
