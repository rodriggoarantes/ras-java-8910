package br.com.ras.java.leetcode.codechallenge.week3;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MinimumPathSumTest {

    private final MinimumPathSum minimumPathSum = new MinimumPathSum();

    @Test
    public void test_case1() {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        assertThat(minimumPathSum.solution(grid), equalTo(7));
    }

}