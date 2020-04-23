package br.com.ras.java.leetcode.codechallenge.week2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiameterBinaryTreeTest {

    final DiameterBinaryTree diameterBinaryTree = new DiameterBinaryTree();

    @Test
    public void case_1() {
        final DiameterBinaryTree.TreeNode root = new DiameterBinaryTree.TreeNode(1);
        root.left = new DiameterBinaryTree.TreeNode(2);
        root.right = new DiameterBinaryTree.TreeNode(3);
        root.left.left = new DiameterBinaryTree.TreeNode(4);
        root.left.right = new DiameterBinaryTree.TreeNode(5);

        DiameterBinaryTree.BinaryTree tree = new DiameterBinaryTree.BinaryTree(root);

        assertThat(tree.diameter(), equalTo(3));
        assertThat(diameterBinaryTree.best(root), equalTo(3));
    }

    @Test
    public void best_1() {
        final DiameterBinaryTree.TreeNode root = new DiameterBinaryTree.TreeNode(1);
        root.left = new DiameterBinaryTree.TreeNode(2);
        root.right = new DiameterBinaryTree.TreeNode(3);
        root.left.left = new DiameterBinaryTree.TreeNode(4);
        root.left.right = new DiameterBinaryTree.TreeNode(5);

        assertThat(diameterBinaryTree.best(root), equalTo(3));
    }

}