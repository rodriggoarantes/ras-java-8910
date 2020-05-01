package br.com.ras.java.leetcode.codechallenge.week5;

import br.com.ras.java.leetcode.codechallenge.shared.TreeNode;

/**
 * Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 *
 * Given a binary tree where each path going from the root to any leaf form a valid sequence,
 * check if a given string is a valid sequence in such binary tree.
 *
 * We get the given string from the concatenation of an array of integers arr and the concatenation of
 * all values of the nodes along a path results in a sequence in the given binary tree.
 *
 *
 * Example 1:
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 *
 * Example 2:
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * Output: false
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 *
 * Example 3:
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 *
 * Constraints:
 *     1 <= arr.length <= 5000
 *     0 <= arr[i] <= 9
 *     Each node's value is between [0 - 9].
 */
public class BinaryTreeValidSequence {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (arr.length == 1) {
            return root.val == arr[0] && (root.left == null && root.right == null);
        }
        return find(root, arr, 0);
    }

    private static boolean find(TreeNode node, int[] arr, int pos) {
        if (node == null || pos == arr.length) {
            return false;
        }
        if (node.left == null && node.right == null) {
            if (node.val == arr[pos] && pos == arr.length - 1) {
                return true;
            }
            return false;
        }

        boolean left = find(node.left, arr, pos + 1);
        boolean right = find(node.right, arr, pos + 1);

        return pos < arr.length && node.val == arr[pos] && (left || right);
    }
}
