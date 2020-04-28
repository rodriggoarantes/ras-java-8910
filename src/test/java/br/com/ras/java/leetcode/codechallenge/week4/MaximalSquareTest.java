package br.com.ras.java.leetcode.codechallenge.week4;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.Test;

public class MaximalSquareTest {
    private final MaximalSquare ms = new MaximalSquare();

    @Test
    public void test_case0() {
        char[][] matrix = new char[][]{{'0'}};
        assertThat(ms.solution(matrix), equalTo(0));
    }

    @Test
    public void test_case2() {
        char[][] matrix = new char[][]{{'1'}};
        assertThat(ms.solution(matrix), equalTo(1));
    }

    @Test
    public void test_case3() {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        assertThat(ms.solution(matrix), equalTo(4));
    }

    @Test
    public void test_case4() {
        char[][] matrix = new char[][]{{'0', '1'}};
        assertThat(ms.solution(matrix), equalTo(1));
    }


}