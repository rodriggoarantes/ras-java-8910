package br.com.ras.java.codechallenge.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * Counting Elements
 *
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * If there're duplicates in arr, count them seperately.
 *
 * Example 1:
 *
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 *
 * Example 2:
 *
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 *
 * Example 3:
 *
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 *
 * Example 4:
 *
 * Input: arr = [1,1,2,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 *
 *
 * Constraints:
 *     1 <= arr.length <= 1000
 *     0 <= arr[i] <= 1000
 */
public class CountingElements {

    public int solution(int[] arr) {
        if (arr.length == 1 || arr.length > 1000) {
            return 0;
        }

        final Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] <= 1000) {
                if (counts.containsKey(arr[i])) {
                    counts.put(arr[i], counts.get(arr[i])+1);
                } else {
                    counts.put(arr[i], 1);
                }
            }
        }

        int count = 0;
        for (int key : counts.keySet()) {
            if (counts.containsKey(key + 1)) {
                count += counts.get(key);
            }
        }

        return count;
    }
}
