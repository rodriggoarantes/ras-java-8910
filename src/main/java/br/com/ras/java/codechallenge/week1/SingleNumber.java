package br.com.ras.java.codechallenge.week1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

  public int solution(int[] nums) {
    final Set<Integer> pull = new HashSet<>(0);
    for (int n : nums) {
      if (pull.contains(n)) {
        pull.remove(n);
      } else {
        pull.add(n);
      }
    }
    return pull.iterator().next();
  }
  
  public int alternative(int[] nums) {
    final HashMap<Integer, Integer> hash_table = new HashMap<>(0);
    for (int i : nums) {
      hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
    }
    for (int i : nums) {
      if (hash_table.get(i) == 1) {
        return i;
      }
    }
    return 0;
  }
  
  public int best(int[] nums) {
    int a = 0;
    for (int i : nums) {
      a ^= i;
    }
    return a;
  }
}
