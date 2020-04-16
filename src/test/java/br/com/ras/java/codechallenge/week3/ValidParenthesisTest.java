package br.com.ras.java.codechallenge.week3;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidParenthesisTest {
    private final ValidParenthesis validParenthesis = new ValidParenthesis();

    @Test
    public void test_case1() {
        String txt = "()";
        assertThat(validParenthesis.checkValidString(txt), equalTo(true));
        assertThat(validParenthesis.best(txt), equalTo(true));
    }

    @Test
    public void test_case2() {
        String txt = "(*)";
        assertThat(validParenthesis.checkValidString(txt), equalTo(true));
        assertThat(validParenthesis.best(txt), equalTo(true));
    }

    @Test
    public void test_case3() {
        String txt = "(*))";
        assertThat(validParenthesis.checkValidString(txt), equalTo(true));
        assertThat(validParenthesis.best(txt), equalTo(true));
    }

    @Test
    public void test_case4() {
        final String txt = ")(";
        assertThat(validParenthesis.checkValidString(txt), equalTo(false));
        assertThat(validParenthesis.best(txt), equalTo(false));
    }

    @Test
    public void test_case5() {
        final String txt = "(((******))";
        assertThat(validParenthesis.checkValidString(txt), equalTo(true));
        assertThat(validParenthesis.best(txt), equalTo(true));
    }

    @Test
    public void test_case6() {
        final String txt = "(*))";
        assertThat(validParenthesis.checkValidString(txt), equalTo(true));
        assertThat(validParenthesis.best(txt), equalTo(true));
    }

    @Test
    public void test_case7() {
        assertThat(validParenthesis.checkValidString("*"), equalTo(true));
        assertThat(validParenthesis.checkValidString(""), equalTo(true));
    }

    @Test
    public void test_case8() {
        final String txt = "(*(()))((())())*(**(()))((*)()(()))*(())()(())(()";
        assertThat(validParenthesis.checkValidString(txt), equalTo(false));
        assertThat(validParenthesis.best(txt), equalTo(false));
    }


}