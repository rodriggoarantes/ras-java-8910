package br.com.ras.java.leetcode.codechallenge.week1;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * <p>A happy number is a number defined by the following process: Starting with any positive
 * integer, replace the number by the sum of the squares of its digits, and repeat the process until
 * the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include
 * 1.
 *
 * <p>Those numbers for which this process ends in 1 are happy numbers.
 *
 * <p>Input: 19 Output: true Explanation: 1^2 + 9^2 = 82 8^2 + 2^2 = 68 6^2 + 8^2 = 100 1^2 + 0^2 +
 * 0^2 = 1
 *
 * @author rodrigo.arantes
 */
public class HappyNumber {
  
  // --- My Solution
  final Set<Integer> previous = new HashSet<>(0);

  public boolean solution(int number) {
    if (number == 1) return true;
    previous.clear();
    return calcHappy(number) == 1;
  }

  private int calcHappy(int n) {
    char[] caracteres = String.valueOf(n).toCharArray();

    int result = 0;
    for (int i = 0; i < caracteres.length; i++) {
      int num = Character.getNumericValue(caracteres[i]);
      result += (num * num);
    }

    if (result > 1 && !previous.add(result)) {
      return this.calcHappy(result);
    }
    return result;
  }
  
  // --- ALTERNATIVE

  public boolean alternative(int number) {
    final Set<Integer> exist = new HashSet<>(0);
    while (number != 1) {
      if (!exist.add(number)) {
        return false;
      }

      int tmp = 0;
      while (number > 0) {
        tmp += Math.pow((number % 10), 2);
        number /= 10;
      }
      number = tmp;
    }
    return true;
  }
  
  // ---- BEST
  public boolean best(int n) {
      int slow = n;
      int fast = n;
      do {
          slow = bestSq(slow);
          fast = bestSq(bestSq(fast));
      } while (slow!=fast);
      return slow == 1? true: false;
  }
  
  private final int bestSq(int n) {
      int num = 0;
      while(n != 0) {
          num = num + (n%10) * (n%10);
          n= n/10;
      }
      return num;
  }
}
