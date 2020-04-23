package br.com.ras.java.leetcode.codechallenge.week1;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
  
  /**
    O enunciado fala: Given a non-empty array of integers, every element appears twice except for one. Find that single one.
    Ou seja, todos elementos aparecem duas vezes exceto por um.
    
    Devemos considerar:
    If we take XOR of zero and some bit, it will return that bit = se compararmos um bit com 0 é retornado ele mesmo
    If we take XOR of two same bits, it will return 0 = se compararmos dois bits do mesmo valor ele retorna 0
    
    então:
    
    [2,2,1] -> [10,10,01]
    0^2 -> 00^10=10
    2^2 -> 10^10=00
    0^1 -> 00^01=01
    resultado = 1
    
    [4,1,2,1,2] -> [11,01,10,01,10]
    0^4 -> 00^11=11
    4^1 -> 11^01=10 (1+0=1 e 1+1=0)
    2^2 -> 10^10=00
    0^1 -> 00^01=01
    1^2 -> 01^10=11
    resultado: 4
   */
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
