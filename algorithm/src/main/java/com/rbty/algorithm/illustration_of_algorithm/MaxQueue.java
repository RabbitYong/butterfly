package com.rbty.algorithm.illustration_of_algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class MaxQueue {
    Deque<Integer> deque, dequeMax;

    public MaxQueue() {
        deque = new LinkedList<>();
        dequeMax = new LinkedList<>();
        dequeMax.push(Integer.MIN_VALUE);
    }

    public int max_value() {
        if (deque.isEmpty())
            return -1;
        return dequeMax.peekFirst();
    }

    public void push_back(int value) {
        deque.addLast(value);
        while (!dequeMax.isEmpty() && value > dequeMax.peekLast()) {
            dequeMax.removeLast();
        }
        dequeMax.addLast(value);
    }

    public int pop_front() {
        if (deque.isEmpty())
            return -1;
        if (deque.peekFirst().equals(dequeMax.peekFirst())) {
            dequeMax.removeFirst();
        }
        return deque.removeFirst();
    }

    public static void main(String[] args) {
        MaxQueue stack = new MaxQueue();
        stack.push_back(1);
        stack.push_back(2);
        stack.pop_front();

        System.out.println(stack.max_value());
    }
}
