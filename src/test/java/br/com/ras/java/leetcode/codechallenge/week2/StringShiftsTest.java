package br.com.ras.java.leetcode.codechallenge.week2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringShiftsTest {

    private final StringShifts stringShifts = new StringShifts();

    @Test
    public void test_case0() {
        String s = "123456";
        int[][] matriz = { {1, 1}, {0, 1}, {0, 2}, {1, 2} };

        final String result = stringShifts.solution(s, matriz);
        assertThat(result, equalTo("123456"));

        final String alternative = stringShifts.alternative(s, matriz);
        assertThat(alternative, equalTo("123456"));
    }

    @Test
    public void test_case1() {
        String s = "abcdefg";
        int[][] matriz = { {1, 1}, {1, 1}, {0, 2}, {1, 3} };

        final String result = stringShifts.solution(s, matriz);
        assertThat(result, equalTo("efgabcd"));

        final String alternative = stringShifts.alternative(s, matriz);
        assertThat(alternative, equalTo("efgabcd"));
    }

    @Test
    public void test_case2() {
        String s = "yisxjwry";
        int[][] matriz = {{1,8},{1,4},{1,3},{1,6},{0,6},{1,4},{0,2},{0,1}};

        final String result = stringShifts.solution(s, matriz);
        assertThat(result, equalTo("yisxjwry"));

        final String alternative = stringShifts.alternative(s, matriz);
        assertThat(alternative, equalTo("yisxjwry"));
    }

    @Test
    public void test_case3() {
        String s = "xqgwkiqpif";
        int[][] matriz = {{1,4},{0,7},{0,8},{0,7},{0,6},{1,3},{0,1},{1,7},{0,5},{0,6}};

        final String result = stringShifts.solution(s, matriz);
        assertThat(result, equalTo("qpifxqgwki"));

        final String alternative = stringShifts.alternative(s, matriz);
        assertThat(alternative, equalTo("qpifxqgwki"));
    }


}