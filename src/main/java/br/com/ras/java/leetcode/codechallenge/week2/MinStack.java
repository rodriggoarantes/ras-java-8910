package br.com.ras.java.leetcode.codechallenge.week2;

import java.util.EmptyStackException;
import java.util.Vector;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *     push(x) -- Push element x onto stack.
 *     pop() -- Removes the element on top of the stack.
 *     top() -- Get the top element.
 *     getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
    private Integer min = Integer.MAX_VALUE;
    private final Vector<Integer> store;

    public MinStack() {
        store = new Vector<>();
    }

    public synchronized void push(int item) {
        store.add(item);
        if (item < min) {
            min = Integer.valueOf(item);
        }
    }

    public synchronized void pop() {
        final int el = top();
        store.removeElementAt(size() - 1);
        if (min == el) {
            this.findMin();
        }
    }

    public synchronized int top() {
        final int len = size();
        if (len == 0)
            throw new EmptyStackException();
        return store.get(len - 1);
    }

    public final int size() {
        return store.size();
    }

    public final int getMin() {
        return min;
    }

    private final void findMin() {
        min = Integer.MAX_VALUE;
        for(Integer item: store) {
            if (item < min) {
                min = item.intValue();
            }
        }
    }
}
