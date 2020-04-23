package br.com.ras.java.leetcode.codechallenge.week3;

/**
 * Search in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < 0) {
            return -1;
        }
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }

        int smallIndex = smallerIndex(nums);
        int start = 0;
        int end = nums.length - 1;

        if (target >= nums[smallIndex] && target <= nums[end]) {
            start = smallIndex;
        } else {
            end = smallIndex;
        }

        return binary(nums, target, start, end);
    }

    private static int middle(int i, int j) {
        return i + (j - i) / 2;
    }

    private static int binary(int[] nums, int target, int i, int j) {
        int middle = middle(i, j);
        if (nums[middle] == target) {
            return middle;
        }
        if (i >= j) {
            return -1;
        }

        if (nums[middle] > target) {
            return binary(nums, target, i, middle - 1);
        } else {
            return binary(nums, target, middle + 1, j);
        }
    }

    private static int smallerIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = middle(left, right);
            int last = nums[right];
            if (nums[mid] > last) {
                left = mid + 1; // ignora a parte esquerda
            } else {
                right = mid; // ignora o lado direito
            }
        }
        return left;
    }

}
