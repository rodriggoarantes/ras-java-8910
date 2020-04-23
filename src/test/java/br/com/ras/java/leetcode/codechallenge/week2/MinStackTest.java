package br.com.ras.java.leetcode.codechallenge.week2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MinStackTest {

    @Test
    public void soluction_cenario1() {
        final MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        assertThat(minStack.getMin(), equalTo(-3));
        minStack.pop(); // remove top

        assertThat(minStack.top(), equalTo(0));
        assertThat(minStack.getMin(), equalTo(-2));
    }

    @Test
    public void soluction_cenario2() {
        final MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        assertThat(minStack.getMin(), equalTo(0));
        minStack.pop(); // remove top
        assertThat(minStack.getMin(), equalTo(0));
        minStack.pop(); // remove top
        assertThat(minStack.getMin(), equalTo(0));
        minStack.pop(); // remove top
        assertThat(minStack.getMin(), equalTo(2));
    }

    @Test
    public void soluction_cenario3() {
        final MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);

        assertThat(minStack.top(), equalTo(2));
        assertThat(minStack.getMin(), equalTo(1));
        minStack.pop(); // remove top
        assertThat(minStack.getMin(), equalTo(1));
        assertThat(minStack.top(), equalTo(1));
    }
}