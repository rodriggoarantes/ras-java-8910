package br.com.ras.java.leetcode.codechallenge.week4;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LongestCommonSubsequenceTest {

    private final LongestCommonSubsequence lcs = new LongestCommonSubsequence();

    @Test
    public void test_case0() {
        String a = "ABCDGH";
        String b = "AEDFHR";
        assertThat(lcs.solution(a, b), equalTo(3)); // ADH
        assertThat(lcs.best(a, b), equalTo(3));
        assertThat(lcs.alternative(a, b), equalTo(3));
    }

    @Test
    public void test_case1() {
        String text1 = "abcde";
        String text2 = "ace";
        assertThat(lcs.solution(text1, text2), equalTo(3)); // ace
        assertThat(lcs.best(text1, text2), equalTo(3));
        assertThat(lcs.alternative(text1, text2), equalTo(3));
    }

    @Test
    public void test_case2() {
        String text1 = "abc";
        String text2 = "abc";
        assertThat(lcs.solution(text1, text2), equalTo(3)); // abc
        assertThat(lcs.best(text1, text2), equalTo(3));
        assertThat(lcs.alternative(text1, text2), equalTo(3));
    }

    @Test
    public void test_case3() {
        String text1 = "abc";
        String text2 = "def";
        assertThat(lcs.solution(text1, text2), equalTo(0));
        assertThat(lcs.best(text1, text2), equalTo(0));
        assertThat(lcs.alternative(text1, text2), equalTo(0));
    }

}