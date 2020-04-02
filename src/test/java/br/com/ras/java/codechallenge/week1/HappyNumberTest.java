package br.com.ras.java.codechallenge.week1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

public class HappyNumberTest {
  
  private final HappyNumber happyNumber = new HappyNumber();
  
  @Test
  public void test_mysolution() {
    assertThat(happyNumber.solution(7), equalTo(true));
    assertThat(happyNumber.solution(19), equalTo(true));
  }
  
  @Test
  public void test_mysolution_infiniti() {
    assertThat(happyNumber.solution(2), equalTo(false));
    assertThat(happyNumber.solution(4), equalTo(false));
    assertThat(happyNumber.solution(5), equalTo(false));
  }
  
  @Test
  public void test_mysolution_um() {
    assertThat(happyNumber.solution(1), equalTo(true));
  }
  
  @Test
  public void test_alternative() {
    assertThat(happyNumber.alternative(19), equalTo(true));
  }
  
  @Test
  public void test_alternative_infiniti() {
    assertThat(happyNumber.alternative(2), equalTo(false));
    assertThat(happyNumber.alternative(4), equalTo(false));
    assertThat(happyNumber.alternative(5), equalTo(false));
  }
  
  @Test
  public void test_alternative_um() {
    assertThat(happyNumber.alternative(1), equalTo(true));
  }
  
  @Test
  public void test_best() {
    assertThat(happyNumber.best(7), equalTo(true));
    assertThat(happyNumber.best(19), equalTo(true));
  }
  
  @Test
  public void test_best_infiniti() {
    assertThat(happyNumber.best(2), equalTo(false));
    assertThat(happyNumber.best(4), equalTo(false));
    assertThat(happyNumber.best(5), equalTo(false));
  }
  
  @Test
  public void test_best_um() {
    assertThat(happyNumber.best(1), equalTo(true));
  }
}
