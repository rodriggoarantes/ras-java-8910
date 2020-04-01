package br.com.ras.java.codechallenge.week1;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

public class SingleNumberTest {
  
  public final SingleNumber singleNumber = new SingleNumber();
  
  @Test
  public void test_solution() {
    final int[] nums = {2, 4, 1, 1, 2, 2};
    final int result = singleNumber.solution(nums);
    assertThat(result, equalTo(4));
  }
  
  @Test
  public void test_alternative() {
    final int[] nums = {1, 2, 4, 1, 1, 3, 2, 2, 4};
    final int result = singleNumber.alternative(nums);
    assertThat(result, equalTo(3));
  }
  
  @Test
  public void test_best_1() {
    final int[] nums = {4,1,2,1,2};
    final int result = singleNumber.best(nums);
    assertThat(result, equalTo(4));
  }
  
  @Test
  public void test_best_2() {
    final int[] nums = {2,2,1};
    final int result = singleNumber.best(nums);
    assertThat(result, equalTo(1));
  }
  
}
