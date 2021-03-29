package com.rbty.algorithm.illustration_of_algorithm;

public class ReverseList {
    /**
     * 双指针
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        return recur(head, null);
    }

    public static ListNode recur(ListNode cur, ListNode prev){
        if (cur == null) return prev;
        ListNode res = recur(cur.next, cur);
        cur.next = prev;
        return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        System.out.println(reverseList2(node1).val);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int x,ListNode next) {
        val = x;
        this.next=next;
    }
}
