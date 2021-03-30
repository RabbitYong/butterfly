package com.rbty.algorithm.illustration_of_algorithm;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {
    /**
     * 使用 Map 存储 复制节点和被复制节点的关系
     *
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        Map<Node, Node> copyMap = new HashMap<>();
        Node cur = head;
        /**
         * 第一次循环，复制值，并将映射关系存入 map
         */
        while (cur != null) {
            Node node = new Node(cur.val);
            copyMap.put(cur, node);
            cur = cur.next;
        }

        /**
         * 第二次循环，复制阶段 的 next 以及 random
         */
        cur = head;
        while (cur != null) {
            Node copyNode = copyMap.get(cur);
            copyNode.next = copyMap.get(cur.next);
            copyNode.random = copyMap.get(cur.random);
            cur = cur.next;
        }
        return copyMap.get(head);
    }

    /**
     * 不使用额外空间。遍历第一遍，将复制节点连接在被复制节点之后；遍历第二遍，复制random；遍历第三遍，拆开。
     */
    public static Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node copyHead;
        while (cur != null) {
            Node next = cur.next;
            Node copy = new Node(cur.val);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            Node copy = cur.next;
            Node next = copy.next;
            copy.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }
        cur = head;
        copyHead = head.next;
        while (cur != null && cur.next != null) {
            Node temp = cur.next;
            cur.next = cur.next.next;
            cur = temp;
        }
        return copyHead;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node2;
        Node node = copyRandomList2(node1);
        System.out.println(node.val);
    }
}
