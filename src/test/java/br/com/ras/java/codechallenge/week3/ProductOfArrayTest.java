package br.com.ras.java.codechallenge.week3;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductOfArrayTest {

    private final ProductOfArray productOfArray = new ProductOfArray();

    @Test
    public void test_case0() {
        int[] nums = new int[]{2,3,4,5};
        assertThat(productOfArray.productExceptSelf(nums), equalTo(new int[]{60, 40, 30, 24}));
        assertThat(productOfArray.best(nums), equalTo(new int[]{60, 40, 30, 24}));
        assertThat(productOfArray.division(nums), equalTo(new int[]{60, 40, 30, 24}));
        assertThat(productOfArray.alternative(nums), equalTo(new int[]{60, 40, 30, 24}));
    }

    @Test
    public void test_case1() {
        int[] nums = new int[]{1, 2, 3, 4};
        assertThat(productOfArray.productExceptSelf(nums), equalTo(new int[]{24, 12, 8, 6}));
        assertThat(productOfArray.best(nums), equalTo(new int[]{24, 12, 8, 6}));
        assertThat(productOfArray.division(nums), equalTo(new int[]{24, 12, 8, 6}));
        assertThat(productOfArray.alternative(nums), equalTo(new int[]{24, 12, 8, 6}));
    }
}