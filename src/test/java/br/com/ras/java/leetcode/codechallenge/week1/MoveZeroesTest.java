package br.com.ras.java.leetcode.codechallenge.week1;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoveZeroesTest {
  
  private final MoveZeroes moveZeroes = new MoveZeroes();
  
  @Test
  public void test_solution_1() {
    int[] numeros = {0,1,0,3,12};
    moveZeroes.solution(numeros);
    assertThat(numeros, equalTo(new int[]{1,3,12,0,0}));
  }
  
  @Test
  public void test_solution_2() {
    int[] numeros = {0,0,1};
    moveZeroes.solution(numeros);
    assertThat(numeros, equalTo(new int[]{1,0,0}));
  }
  
  @Test
  public void test_solution_3() {
    int[] numeros = {0,9,0,8,0,7};
    moveZeroes.solution(numeros);
    assertThat(numeros, equalTo(new int[]{9,8,7,0,0,0}));
  }
  
  @Test
  public void test_solution_4() {
    int[] numeros = {0,0,0,1,2,3};
    moveZeroes.solution(numeros);
    assertThat(numeros, equalTo(new int[]{1,2,3,0,0,0}));
  }
  
  @Test
  public void test_solution_5() {
    int[] numeros = {1};
    moveZeroes.solution(numeros);
    assertThat(numeros, equalTo(new int[]{1}));
  }
  
  @Test
  public void test_solution_6() {
    int[] numeros = {1,2,3};
    moveZeroes.solution(numeros);
    assertThat(numeros, equalTo(new int[]{1,2,3}));
  }
  
}


