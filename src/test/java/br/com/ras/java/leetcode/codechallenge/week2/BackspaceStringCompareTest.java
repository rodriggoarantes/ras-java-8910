package br.com.ras.java.leetcode.codechallenge.week2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class BackspaceStringCompareTest {

    private final BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();

    @Test
    public void test_backspace_case1() {
        String text = BackspaceStringCompare.backspace("ab#c#");
        assertThat(text, equalTo("a"));
    }

    @Test
    public void test_backspace_case2() {
        String text = BackspaceStringCompare.backspace("a#b#c#ddd#");
        assertThat(text, equalTo("dd"));
    }

    @Test
    public void test_solution_case1() {
        String S = "ab#c";
        String T = "ad#c";
        boolean solution = backspaceStringCompare.solution(S, T);
        boolean alternative = backspaceStringCompare.alternative(S, T);
        assertThat(solution, equalTo(true));
        assertThat(alternative, equalTo(true));
    }

    @Test
    public void test_solution_case2() {
        String S = "ab##";
        String T = "c#d#";

        boolean solution = backspaceStringCompare.solution(S, T);
        boolean alternative = backspaceStringCompare.alternative(S, T);
        assertThat(solution, equalTo(true));
        assertThat(alternative, equalTo(true));
    }

    @Test
    public void test_solution_case3() {
        String S = "a##c";
        String T = "#a#c";
        boolean solution = backspaceStringCompare.solution(S, T);
        boolean alternative = backspaceStringCompare.alternative(S, T);
        assertThat(solution, equalTo(true));
        assertThat(alternative, equalTo(true));
    }

    @Test
    public void test_solution_case4() {
        String S = "a#c";
        String T = "b";
        boolean solution = backspaceStringCompare.solution(S, T);
        boolean alternative = backspaceStringCompare.alternative(S, T);
        assertThat(solution, equalTo(false));
        assertThat(alternative, equalTo(false));
    }
}