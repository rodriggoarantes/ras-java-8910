package br.com.ras.java.leetcode.codechallenge.week5;

import br.com.ras.java.leetcode.codechallenge.shared.TreeNode;
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
        final TreeNode root = new TreeNode(1);
        root.left =  new TreeNode(2);
        root.right =  new TreeNode(3);
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
        final TreeNode root = new TreeNode(-10);
        root.left =  new TreeNode(9);
        root.right =  new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertThat(treeMaximumPathSum.maxPathSum(root), equalTo(42));
    }

    /**
     *     2
     *    / \
     *   -1
     */
    @Test
    public void test_case3() {
        final TreeNode root = new TreeNode(2);
        root.left =  new TreeNode(-1);
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
        final TreeNode root = new TreeNode(1);
        root.left =  new TreeNode(-2);
        root.right =  new TreeNode(3);
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
        final TreeNode root = new TreeNode(1);
        root.left =  new TreeNode(2);
        root.left.left =  new TreeNode(3);
        root.left.left.left =  new TreeNode(4);
        root.left.left.left.left =  new TreeNode(5);
        assertThat(treeMaximumPathSum.maxPathSum(root), equalTo(15));
    }

}