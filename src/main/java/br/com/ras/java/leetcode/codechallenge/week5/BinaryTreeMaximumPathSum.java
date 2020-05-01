package br.com.ras.java.leetcode.codechallenge.week5;

import br.com.ras.java.leetcode.codechallenge.shared.TreeNode;

/**
 * Binary Tree Maximum Path Sum
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along
 * the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 *
 */
public class BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;
    private int sum(TreeNode node) {
        if (node == null) return 0;
        int L = sum(node.left);
        int R = sum(node.right);
        max = Math.max(max, Math.max(R+node.val, L+node.val));
        max = Math.max(max, Math.max(L+R+node.val, node.val));
        return Math.max(node.val, Math.max(R+node.val, L+node.val));
    }

    public int maxPathSum(TreeNode root) {
        sum(root);
        return max;
    }


    public int solution(TreeNode root) {
        return sumb(root);
    }

    private static int sumb(TreeNode node) {
        if (node == null) return 0;

        int countL = altura(node.left);
        int countR = altura(node.right);

        int diametroL = sumb(node.left);
        int diametroR = sumb(node.right);

        return Math.max(Math.max(countL, countR), Math.max(diametroL+diametroR+node.val, node.val));
    }

    private static int altura(TreeNode node) {
        if (node == null) return 0;
        return Math.max(node.val, Math.max(altura(node.right) + node.val, altura(node.left) + node.val));
    }

}
