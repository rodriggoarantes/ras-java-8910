package br.com.ras.java.leetcode.codechallenge.week3;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class SearchRotatedSortedArrayTest {

    public final SearchRotatedSortedArray searchRotatedSortedArray = new SearchRotatedSortedArray();

    @Test
    public void test_case1() {
        final int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(searchRotatedSortedArray.search(nums, 5), equalTo(5));
    }

    @Test
    public void test_case2() {
        final int[] nums = new int[]{4,5,6,7,0,1,2};
        assertThat(searchRotatedSortedArray.search(nums, 0), equalTo(4));
    }



}