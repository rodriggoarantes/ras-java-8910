package br.com.ras.java.codechallenge.week3;

/**
 * Minimum Path Sum
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
    
    public int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        int [][] sums = new int[grid.length][grid[0].length];

        for (int i = 0; i < sums.length; i++) {
            for (int j = 0; j < sums[0].length; j++) {
                sums[i][j] += grid[i][j];
                if (i > 0 && j > 0) {
                    int top = sums[i - 1][j];
                    int left = sums[i][j - 1];
                    sums[i][j] += Math.min(top, left);
                } else if (i > 0) {
                    sums[i][j] += sums[i - 1][j];
                } else if (j > 0) {
                    sums[i][j] += sums[i][j - 1];
                }
            }
        }
        return sums[sums.length - 1][sums[0].length -1];
    }
}
