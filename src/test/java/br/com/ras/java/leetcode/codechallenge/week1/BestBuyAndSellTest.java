package br.com.ras.java.leetcode.codechallenge.week1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BestBuyAndSellTest {
	
	private final BestBuyAndSell bestBuySell = new BestBuyAndSell();
	
	@Test
	public void test_solution_normal() {
		final int[] nums = {7,1,5,3,6,4};
		assertThat(bestBuySell.solution(nums), equalTo(7));
	}
	
	@Test
	public void test_solution_lastSell() {
		final int[] nums = {1,2,3,4,5};
		assertThat(bestBuySell.solution(nums), equalTo(4));
	}
	
	@Test
	public void test_solution_erro1() {
		final int[] nums = {6,1,3,2,4,7};
		assertThat(bestBuySell.solution(nums), equalTo(7));
	}
	
	@Test
	public void test_alternative_normal() {
		final int[] nums = {7,1,5,3,6,4};
		assertThat(bestBuySell.alternative(nums), equalTo(7));
	}
	
	@Test
	public void test_alternative_lastSell() {
		final int[] nums = {1,2,3,4,5};
		assertThat(bestBuySell.alternative(nums), equalTo(4));
	}
	
	@Test
	public void test_alternative_erro1() {
		final int[] nums = {6,1,3,2,4,7};
		assertThat(bestBuySell.alternative(nums), equalTo(7));
	}
}
