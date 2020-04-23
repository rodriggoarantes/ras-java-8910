package br.com.ras.java.leetcode.codechallenge.week1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class CountingElementsTest {

    private final CountingElements countingElements = new CountingElements();

    @Test
    public void solution_1() {
        int[] array = new int[]{1,1,2,2};
        int count = countingElements.solution(array);
        assertThat(count, equalTo(2));
    }

    @Test
    public void solution_2() {
        int[] array = new int[]{1,2,3};
        int count = countingElements.solution(array);
        assertThat(count, equalTo(2));
    }

    @Test
    public void solution_3() {
        int[] array = new int[]{1,3,2,3,5,0};
        int count = countingElements.solution(array);
        assertThat(count, equalTo(3));
    }

    @Test
    public void solution_none() {
        int[] array = new int[]{1,1,3,3,5,5,7,7};
        int count = countingElements.solution(array);
        assertThat(count, equalTo(0));
    }
}