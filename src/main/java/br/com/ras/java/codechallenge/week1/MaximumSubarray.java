package br.com.ras.java.codechallenge.week1;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 *
 * <p>Example:
 *
 * <p>Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * <p>If you have figured out the O(n) solution, try coding another solution using the divide and
 * conquer approach, which is more subtle.
 *
 * @author rodrigo.arantes
 */
public class MaximumSubarray {

  public int solution(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    int end = nums.length;
    int max = nums[0];
    int sums = 0;

    for (int i = 0; i < end; i++) {
      sums = sums + nums[i];
      if (max < sums) {
        max = sums;
      }
      if (sums < 0) {
        sums = 0;
      }
    }

    return max;
  }

  public int alternative(int[] nums) {
    int maxSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > 0) {
        nums[i] += nums[i - 1];
      }
      maxSum = Math.max(maxSum, nums[i]);
    }
    return maxSum;
  }
}
