package br.com.ras.java.leetcode.codechallenge.week4;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BitwiseNumbersRangeTest {
    private final BitwiseNumbersRange bitwiseNumbersRange = new BitwiseNumbersRange();

    @Test
    public void test_case1() {
        int m = 5, n = 7;
        assertThat(bitwiseNumbersRange.solution(m, n), equalTo(4));
        assertThat(bitwiseNumbersRange.rangeBitwiseAnd(m, n), equalTo(4));
    }

    @Test
    public void test_case2() {
        int m = 0, n = 1;
        assertThat(bitwiseNumbersRange.solution(m, n), equalTo(0));
        assertThat(bitwiseNumbersRange.rangeBitwiseAnd(m, n), equalTo(0));
    }

    @Test
    public void test_case3() {
        int m = 0, n = 2147483647;
        assertThat(bitwiseNumbersRange.solution(m, n), equalTo(0));
        assertThat(bitwiseNumbersRange.rangeBitwiseAnd(m, n), equalTo(0));
    }

    @Test
    public void test_case4() {
        int m = 10, n = 20;
        assertThat(bitwiseNumbersRange.solution(m, n), equalTo(0));
        assertThat(bitwiseNumbersRange.rangeBitwiseAnd(m, n), equalTo(0));
    }

    @Test
    public void test_case5() {
        int m = 6, n = 7;
        assertThat(bitwiseNumbersRange.solution(m, n), equalTo(6));
        assertThat(bitwiseNumbersRange.rangeBitwiseAnd(m, n), equalTo(6));
    }

}