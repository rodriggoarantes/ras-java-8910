package br.com.ras.java.leetcode.codechallenge.week5;

import br.com.ras.java.leetcode.codechallenge.shared.BinaryTree;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinaryTreeMaximumPathSumTest {

    private final BinaryTreeMaximumPathSum treeMaximumPathSum = new BinaryTreeMaximumPathSum();

    /**
     *     1
     *    / \
     *   2   3
     */
    @Test
    public void test_case1() {
        final BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
        root.left =  new BinaryTree.TreeNode(2);
        root.right =  new BinaryTree.TreeNode(3);
        assertThat(treeMaximumPathSum.maxPathSum(root), equalTo(6));
        assertThat(treeMaximumPathSum.solution(root), equalTo(6));
    }

    /**
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    @Test
    public void test_case2() {
        final BinaryTree.TreeNode root = new BinaryTree.TreeNode(-10);
        root.left =  new BinaryTree.TreeNode(9);
        root.right =  new BinaryTree.TreeNode(20);
        root.right.left = new BinaryTree.TreeNode(15);
        root.right.right = new BinaryTree.TreeNode(7);
        assertThat(treeMaximumPathSum.maxPathSum(root), equalTo(42));
    }

    /**
     *     2
     *    / \
     *   -1
     */
    @Test
    public void test_case3() {
        final BinaryTree.TreeNode root = new BinaryTree.TreeNode(2);
        root.left =  new BinaryTree.TreeNode(-1);
        assertThat(treeMaximumPathSum.maxPathSum(root), equalTo(2));
        assertThat(treeMaximumPathSum.solution(root), equalTo(2));
    }

    /**
     *     2
     *    / \
     *   -1
     */
    @Test
    public void test_case4() {
        final BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
        root.left =  new BinaryTree.TreeNode(-2);
        root.right =  new BinaryTree.TreeNode(3);
        assertThat(treeMaximumPathSum.maxPathSum(root), equalTo(4));
        assertThat(treeMaximumPathSum.solution(root), equalTo(4));
    }

    /**
     *     2
     *    / \
     *   -1
     */
    @Test
    public void test_case5() {
        final BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
        root.left =  new BinaryTree.TreeNode(2);
        root.left.left =  new BinaryTree.TreeNode(3);
        root.left.left.left =  new BinaryTree.TreeNode(4);
        root.left.left.left.left =  new BinaryTree.TreeNode(5);
        assertThat(treeMaximumPathSum.maxPathSum(root), equalTo(15));
    }

}