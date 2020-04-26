package br.com.ras.java.leetcode.codechallenge.week4;

/**
 * Longest Common Subsequence
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * If there is no common subsequence, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 */
public class LongestCommonSubsequence {

    public int best(String text1, String text2) {
        char[] t1 = text1.toCharArray(), t2 = text2.toCharArray();
        int dp[] = new int[t2.length+1];
        for(int i = 1; i <= t1.length; i++) {
            int prev = 0;
            for(int j = 1; j <= t2.length; j++) {
                int tmp = dp[j];
                if(t1[i-1] == t2[j-1]) dp[j] = prev + 1;
                else dp[j] = Math.max(dp[j], dp[j-1]);
                prev = tmp;
            }
        }
        return dp[t2.length];
    }

    public int alternative(String text1, String text2) {

        char[] charX = text1.toCharArray();
        char[] charY = text2.toCharArray();
        int x = charX.length;
        int y = charY.length;

        return lcs(charX, charY, x, y);
    }

    public int solution(String text1, String text2) {

        char[] charX = text1.toCharArray();
        char[] charY = text2.toCharArray();
        int x = charX.length;
        int y = charY.length;

        return search(charX, charY, x, y);
    }

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    private int lcs(char[] X, char[] Y, int m, int n ) {
        int L[][] = new int[m+1][n+1];

        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }

    private int search(char[] X, char[] Y, int x, int y) {
        if (x == 0 || y == 0)
            return 0;
        if (X[x-1] == Y[y-1])
            return 1 + search(X, Y, x-1, y-1);
        else
            return Math.max(search(X, Y, x, y-1), search(X, Y, x-1, y));
    }
}
