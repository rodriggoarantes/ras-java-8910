package br.com.ras.java.leetcode.codechallenge.week1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaximumSubarrayTest {
 
  private final MaximumSubarray maximumSubarray = new MaximumSubarray();
  
  @Test
  public void test() {
    assertThat((9/2), equalTo(4));
  }
  
  @Test
  public void test_mysolution_1() {
    final int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    assertThat(maximumSubarray.solution(array), equalTo(6));
  }
  
  @Test
  public void test_mysolution_2() {
    final int[] array = {4,-1,2,1};
    assertThat(maximumSubarray.solution(array), equalTo(6));
  }
  
  @Test
  public void test_mysolution_3() {
    final int[] array = {-2,1};
    assertThat(maximumSubarray.solution(array), equalTo(1));
  }
  
  @Test
  public void test_mysolution_4() {
    final int[] array = {-2,-1};
    assertThat(maximumSubarray.solution(array), equalTo(-1));
  }
  
  @Test
  public void test_alternative_1() {
    final int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    assertThat(maximumSubarray.alternative(array), equalTo(6));
  }
  
  @Test
  public void test_alternative_2() {
    final int[] array = {4,-1,2,1};
    assertThat(maximumSubarray.alternative(array), equalTo(6));
  }
  
  @Test
  public void test_alternative_3() {
    final int[] array = {-2,1};
    assertThat(maximumSubarray.alternative(array), equalTo(1));
  }
  
  @Test
  public void test_alternative_4() {
    final int[] array = {-2,-1};
    assertThat(maximumSubarray.alternative(array), equalTo(-1));
  }
}
