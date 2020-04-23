package br.com.ras.java.leetcode.codechallenge.week2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContiguousArrayTest {

    private final ContiguousArray contiguousArray = new ContiguousArray();

    @Test
    public void solution_case1() {
        int[] array = new int[]{0,1};
        assertThat(contiguousArray.solution(array), equalTo(2));
    }

    @Test
    public void solution_case2() {
        int[] array = new int[]{0,1,0};
        assertThat(contiguousArray.solution(array), equalTo(2));
    }

    @Test
    public void solution_case3() {
        int[] array = new int[]{0,0,0,1,1,1};
        assertThat(contiguousArray.solution(array), equalTo(6));
    }

    @Test
    public void solution_case4() {
        int[] array = new int[]{0,1,1,0,1,1,0,1};
        assertThat(contiguousArray.solution(array), equalTo(4));
    }

    @Test
    public void solution_case5() {
        int[] array = new int[]{1};
        assertThat(contiguousArray.solution(array), equalTo(0));
    }

}