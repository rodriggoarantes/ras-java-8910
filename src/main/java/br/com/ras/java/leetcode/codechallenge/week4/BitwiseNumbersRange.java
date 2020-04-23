package br.com.ras.java.leetcode.codechallenge.week4;

/**
 * Bitwise AND of Numbers Range
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 *  return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 *
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 */
public class BitwiseNumbersRange {

    public int solution(int m, int n) {
        int num = m;
        while (m < n) {
            if (num == 0) {
                return 0;
            }
            num &= ++m;
        }
        return num;
    }

    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m & n;
        }
        int result = 0;
        int mbsM = mbs(m);
        int mbsN = mbs(n);
        while (mbsM == mbsN) {
            int msbNew = (int) Math.pow(2, mbsM); // (1 << mbsM)
            result += msbNew;
            m = m - msbNew;
            n = n - msbNew;
            mbsM = mbs(m);
            mbsN = mbs(n);
        }
        return result;
    }

    private static int mbs(int num) {
        int msb = -1;
        while (num > 0) {
            num = num >> 1;
            msb++;
        }
        return msb;
    }
}
