package br.com.ras.java.codechallenge.week3;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LeftmostColumnLeastOneTest {
    private final LeftmostColumnLeastOne leftmostColumnLeastOne = new LeftmostColumnLeastOne();

    @Test
    public void test_case1() {
        int nums[][] = new int[][]{{0,0},{1,1}};
        LeftmostColumnLeastOne.BinaryMatrix matrix = new LeftmostColumnLeastOne.BinaryMatrixImpl(nums);

        int result = leftmostColumnLeastOne.solution(matrix);
        assertThat(result, equalTo(0));
    }

    @Test
    public void test_case2() {
        int nums[][] = new int[][]{{0,0},{0,1}};
        LeftmostColumnLeastOne.BinaryMatrix matrix = new LeftmostColumnLeastOne.BinaryMatrixImpl(nums);

        int result = leftmostColumnLeastOne.solution(matrix);
        assertThat(result, equalTo(1));
    }

    @Test
    public void test_case3() {
        int nums[][] = new int[][]{{0,0},{0,0}};
        LeftmostColumnLeastOne.BinaryMatrix matrix = new LeftmostColumnLeastOne.BinaryMatrixImpl(nums);

        int result = leftmostColumnLeastOne.solution(matrix);
        assertThat(result, equalTo(-1));
    }

    @Test
    public void test_case4() {
        int nums[][] = new int[][]{{0,0,0,1},{0,0,1,1},{0,1,1,1}};
        LeftmostColumnLeastOne.BinaryMatrix matrix = new LeftmostColumnLeastOne.BinaryMatrixImpl(nums);

        int result = leftmostColumnLeastOne.solution(matrix);
        assertThat(result, equalTo(1));
    }
}