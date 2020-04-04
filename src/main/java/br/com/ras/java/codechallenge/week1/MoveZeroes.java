package br.com.ras.java.codechallenge.week1;


/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *  
 * Example:
 *  
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Input: [0,0,0,1]
 * Output: [1,0,0,0]
 * 
 * Note:
 *  
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 * @author rodrigo.arantes
 */
public class MoveZeroes {
  
  public void solution(int[] nums) {
    int space = -1;
    if (nums.length > 1) {
      for (int i=0; i < nums.length; i++) {
        if (nums[i] != 0 && space >= 0) {
          int value = nums[i];
          nums[space] = value;
          nums[i] = 0;
          space++;
        }
        if (nums[i] == 0 && space == -1) {
          space = i;
        }
      }
    }
  }
  
  
  
  public void solution1(int[] nums) {
    int countZero = 0;
    for (int i=0; i < nums.length; i++) {
      if (nums[i] == 0) {
        for (int j = i; j < nums.length; j++) {
          if (j >= (nums.length - 1) - (countZero)) {
            nums[j] = 0;
          } else {
            nums[j] = nums[j+1];  
          }
        }
        countZero++;
      }
    }
  }
  
}
