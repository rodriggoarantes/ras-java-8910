package br.com.ras.java.codechallenge.week3;

import java.util.Arrays;

/**
 * Product of Array Except Self (DIA 15)
 *
 * Given an array nums of n integers where n > 1, return an array output such that output[i]
 * is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the
 * array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as
 * extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArray {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1 ) return nums;

        int size = nums.length;
        int[] left = new int[size];
        left[0] = 1;
        int[] right = new int[size];
        right[size - 1] = 1;

        // preencher a esquerda
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i-1] * left[i-1];
        }
        // preencher a direita
        for (int j = size - 2; j >= 0; j--) {
            right[j] = nums[j+1] * right[j+1];
        }

        int[] result = new int[size];
        for (int x = 0; x < result.length; x++) {
            result[x] = left[x] * right[x];
        }

        return result;
    }

    public int[] best(int[] nums) {
        if (nums.length == 0) return nums;
        int N = nums.length;
        int[] q = new int[N];
        int p = 1;
        q[N-1] = 1;

        for (int i=N-2;i>=0;i--) {
            q[i] = q[i+1]*nums[i+1];
        }
        for (int i=0;i<N;i++) {
            q[i] =  p * q[i];
            p = p*nums[i];
        }
        return q;
    }

    public int[] alternative(int[] nums) {
        int[] prod = new int[nums.length];
        Arrays.fill(prod, 1);
        int leftProd = 1; int rightProd = 1;
        for(int i = 1; i < nums.length; i++) {
            leftProd *= nums[i-1];
            prod[i] *= leftProd;
        }
        for(int i = nums.length-2; i>=0; i--) {
            rightProd = nums[i+1] * rightProd;
            prod[i]*=rightProd;
        }
        return prod;
    }

    public int[] division(int[] nums) {
        if (nums == null || nums.length <= 1 ) return nums;

        int totalProds = 1;
        int[] products = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            totalProds *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            products[i] = totalProds / nums[i];
        }

        return products;
    }
}
