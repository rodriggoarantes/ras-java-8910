package br.com.ras.java.leetcode.codechallenge.week2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LastStoneWeightTest {

    private final LastStoneWeight stoneWeight = new LastStoneWeight();

    @Test
    public void case_1() {
        int[] array = new int[]{2,7,4,1,8,1};
        assertThat(stoneWeight.solution(array), equalTo(1));
    }

    @Test
    public void best_1() {
        int[] array = new int[]{2,7,4,1,8,1};
        assertThat(stoneWeight.best(array), equalTo(1));
    }

}