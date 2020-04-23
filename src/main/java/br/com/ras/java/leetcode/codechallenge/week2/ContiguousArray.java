package br.com.ras.java.leetcode.codechallenge.week2;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Contiguous Array
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 *
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 *
 * Example 2:
 *
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class ContiguousArray {

    public int solution(int[] nums) {
        if (nums == null || nums.length < 2 || nums.length > 50000) {
            return 0;
        }

        // mapa para armazenar contagem e index/posicao
        final HashMap<Integer, Integer> mapa = new HashMap<>();
        mapa.put(0, -1);

        int max = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count += -1;
            } else {
                count += 1;
            }

            if (mapa.containsKey(count)) {
                // verifica se o valor maximo é maior que a diferença entre os indices de numeros iguais
                // ultimo index onde foi encontrado a mesma contagem
                max = Math.max(max, i - mapa.get(count));
            } else {
                mapa.put(count, i);
            }
        }

        return max;
    }

    public int alternative(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return maxlen;
    }

    public int best(int[] nums) {
        int n = nums.length;
        int[] recorder = new int[2 * nums.length + 1];

        for( int i = 0; i < recorder.length; i++) recorder[i] = -2;

        int sum = n;
        int max = 0;
        recorder[n] = -1;

        for ( int i = 0; i < nums.length; i++){
            sum += (nums[i] * 2 - 1);
            if (recorder[sum] == -2)
                recorder[sum] = i;
            else
                max = Math.max(max, i - recorder[sum]);
        }
        return max;
    }
}
