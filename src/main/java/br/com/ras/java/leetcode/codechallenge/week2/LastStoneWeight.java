package br.com.ras.java.leetcode.codechallenge.week2;

import java.util.Arrays;

/**
 * Last Stone Weight
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 *     If x == y, both stones are totally destroyed;
 *     If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 *
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 * Note:
 *     1 <= stones.length <= 30
 *     1 <= stones[i] <= 1000
 */
public class LastStoneWeight {
    public int solution(int[] stones) {
        if (stones == null || stones.length < 1 || stones.length > 30) {
            return 0;
        } else if (stones.length == 1) {
            return stones[0];
        } else if (stones.length == 2) {
            return stones[1] > stones[0] ? stones[1] - stones[0] : stones[0] - stones[1];
        }

        Arrays.sort(stones);

        for (int i = stones.length - 1; i > 0; i--) {
            int x = stones[i];
            int y = stones[i - 1];

            if (x == y) {
                stones[i - 1] = 0;
            } else {
                stones[i - 1] = x - y;
            }

            stones[i] = 0;
            Arrays.sort(stones, 0, i);
        }

        return stones[0];
    }

    public int best(int[] stones) {
        // Set up the bucket array.
        int maxWeight = stones[0];
        for (int stone: stones) {
            maxWeight = Math.max(maxWeight, stone);
        }
        int[] buckets = new int[maxWeight + 1];

        // Bucket sort.
        for (int weight : stones) {
            buckets[weight]++;
        }

        // Scan through the buckets.
        int biggestWeight = 0;
        int currentWeight = maxWeight;
        while (currentWeight > 0) {
            if (buckets[currentWeight] == 0) {
                currentWeight--;
            } else if (biggestWeight == 0) {
                buckets[currentWeight] %= 2;
                if (buckets[currentWeight] == 1) {
                    biggestWeight = currentWeight;
                }
                currentWeight--;
            } else {
                buckets[currentWeight]--;
                if (biggestWeight - currentWeight <= currentWeight) {
                    buckets[biggestWeight - currentWeight]++;
                    biggestWeight = 0;
                } else {
                    biggestWeight -= currentWeight;
                }
            }
        }
        return biggestWeight;
    }
}
