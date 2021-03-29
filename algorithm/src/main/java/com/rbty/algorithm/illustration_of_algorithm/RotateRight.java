package com.rbty.algorithm.illustration_of_algorithm;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/3/27 10:43
 */
public class RotateRight {
    public static ListNode rotateRight(ListNode head,int k){
        if (head == null){
            return head;
        }
        ListNode curr = head;
        int size = 1;
        while (curr.next!=null){
            curr = curr.next;
            size ++;
        }
        curr.next = head;

        curr = head;
        int breakPoint = size - k%size;
        int point = 1;
        while (curr!=null){
            if (point == breakPoint){
                head = curr.next;
                curr.next = null;
                return head;
            }
            curr = curr.next;
            point ++;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = rotateRight(node1,2);
        System.out.println(head);

    }
}
