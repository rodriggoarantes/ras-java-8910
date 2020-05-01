package br.com.ras.java.leetcode.codechallenge.week3;

import br.com.ras.java.leetcode.codechallenge.shared.BinaryTree;
import br.com.ras.java.leetcode.codechallenge.shared.TreeNode;

/**
 *  * Construct Binary Search Tree from Preorder Traversal
 *
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node,
 * any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
 * Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 *
 *
 * Example 1:
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 *           8
 *          / \
 *         5   10
 *        / \   \
 *       1   7   12
 *
 * Note:
 *     1 <= preorder.length <= 100
 *     The values of preorder are distinct.
 */
public class BinarySearchTree {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        BinaryTree bt = new BinaryTree(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            bt.add(preorder[i]);
        }

        return bt.getRoot();
    }


}
