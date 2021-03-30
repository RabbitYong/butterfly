package com.rbty.algorithm.illustration_of_algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    List<Integer> values = new ArrayList<>();
    Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        Iterator<NestedInteger> iterator = nestedList.iterator();
        while (iterator.hasNext()) {
            NestedInteger nestedInteger = iterator.next();
            if (nestedInteger.isInteger()) {
                values.add(nestedInteger.getInteger());
            } else {
                dfs(nestedInteger);
            }
        }
        it = values.iterator();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    private void dfs(NestedInteger nestedInteger) {
        List<NestedInteger> list = nestedInteger.getList();
        Iterator<NestedInteger> iterator = list.iterator();
        while (iterator.hasNext()) {
            NestedInteger next = iterator.next();
            if (next.isInteger()) {
                values.add(next.getInteger());
            } else {
                dfs(next);
            }
        }
    }
}
