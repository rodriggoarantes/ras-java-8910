package br.com.ras.java.leetcode.codechallenge.week5;

import br.com.ras.java.leetcode.codechallenge.shared.TreeNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinaryTreeValidSequenceTest {

    private final BinaryTreeValidSequence btvs = new BinaryTreeValidSequence();

    @Test
    public void test_case1() {
        final TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.left.left = new TreeNode(0);
        node.left.left.right = new TreeNode(1);
        node.left.right = new TreeNode(1);
        node.left.right.left = new TreeNode(0);
        node.left.right.right = new TreeNode(0);
        node.right = new TreeNode(0);
        node.right.left = new TreeNode(0);

        assertThat(btvs.isValidSequence(node, new int[]{0,1,0,1}), equalTo(true));
        assertThat(btvs.isValidSequence(node, new int[]{0,1,1,0}), equalTo(true));
        assertThat(btvs.isValidSequence(node, new int[]{0,0,0}), equalTo(true));
    }

    @Test
    public void test_case2() {
        final TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.left.left = new TreeNode(0);
        node.left.left.right = new TreeNode(1);
        node.left.right = new TreeNode(1);
        node.left.right.left = new TreeNode(0);
        node.left.right.right = new TreeNode(0);
        node.right = new TreeNode(0);
        node.right.left = new TreeNode(0);

        assertThat(btvs.isValidSequence(node, new int[]{0,0}), equalTo(false));
        assertThat(btvs.isValidSequence(node, new int[]{0,0,1}), equalTo(false));
        assertThat(btvs.isValidSequence(node, new int[]{0,1,1}), equalTo(false));
    }

}