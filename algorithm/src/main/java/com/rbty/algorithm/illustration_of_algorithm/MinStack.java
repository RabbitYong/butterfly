package com.rbty.algorithm.illustration_of_algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 辅助栈法，O(1) 时间 获得栈中最小值
 */
public class MinStack {
    Deque<Integer> stack ;
    Deque<Integer> stackMin ;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        stackMin = new LinkedList();
        stackMin.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        if (x <= stackMin.peek()){
            stackMin.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(stackMin.peek())){
            stackMin.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
        stack.pop();
        stack.min();
        stack.pop();
        stack.min();
        stack.pop();
        stack.min();
    }
}
