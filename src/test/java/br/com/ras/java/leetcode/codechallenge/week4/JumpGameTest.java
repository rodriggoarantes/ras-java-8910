package br.com.ras.java.leetcode.codechallenge.week4;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class JumpGameTest {

    private final JumpGame jumpGame = new JumpGame();

    @Test
    public void test_case1() {
        int[] nums = new int[]{2,3,1,1,4};
        assertThat(jumpGame.canJump(nums), equalTo(true));
        assertThat(jumpGame.alternative(nums), equalTo(true));
    }

    @Test
    public void test_case2() {
        int[] nums = new int[]{3,2,1,0,4};
        assertThat(jumpGame.canJump(nums), equalTo(false));
        assertThat(jumpGame.alternative(nums), equalTo(false));
    }

    @Test
    public void test_case3() {
        int[] nums = new int[]{2,0};
        assertThat(jumpGame.canJump(nums), equalTo(true));
        assertThat(jumpGame.alternative(nums), equalTo(true));
    }

    @Test
    public void test_case4() {
        int[] nums = new int[]{2,0,0};
        assertThat(jumpGame.canJump(nums), equalTo(true));
        assertThat(jumpGame.alternative(nums), equalTo(true));
    }

    @Test
    public void test_case5() {
        int[] nums = new int[]{4,0,4,2,2,0,1,3,3,0,3};
        assertThat(jumpGame.canJump(nums), equalTo(true));
        assertThat(jumpGame.alternative(nums), equalTo(true));
    }
}