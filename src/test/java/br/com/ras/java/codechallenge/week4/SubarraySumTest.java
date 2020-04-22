package br.com.ras.java.codechallenge.week4;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SubarraySumTest {

    private final SubarraySum subarraySum = new SubarraySum();

    @Test
    public void test_case1() {
        int[] nums = new int[]{1, 1, 1};
        assertThat(subarraySum.solution(nums, 2), equalTo(2));
    }

    @Test
    public void test_case2() {
        int[] nums = new int[]{1, 2, 3};
        assertThat(subarraySum.solution(nums, 3), equalTo(2));
    }

    @Test
    public void test_case3() {
        int[] nums = new int[]{1,2,1,2,1};
        assertThat(subarraySum.solution(nums, 3), equalTo(4));
    }

    @Test
    public void test_case4() {
        int[] nums = new int[]{-1,-1,1};
        assertThat(subarraySum.solution(nums, 0), equalTo(1));
    }

    @Test
    public void test_case5() {
        int[] nums = new int[]{100,1,2,3,4};
        assertThat(subarraySum.solution(nums, 6), equalTo(1));
    }
}