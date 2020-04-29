package br.com.ras.java.leetcode.codechallenge.week2;

import br.com.ras.java.leetcode.codechallenge.shared.BinaryTree;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiameterBinaryTreeTest {

    final DiameterBinaryTree diameterBinaryTree = new DiameterBinaryTree();

    @Test
    public void case_1() {
        final BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
        root.left = new BinaryTree.TreeNode(2);
        root.right = new BinaryTree.TreeNode(3);
        root.left.left = new BinaryTree.TreeNode(4);
        root.left.right = new BinaryTree.TreeNode(5);

        BinaryTree tree = new BinaryTree(root);

        assertThat(tree.diameter(), equalTo(3));
        assertThat(diameterBinaryTree.best(root), equalTo(3));
    }

    @Test
    public void best_1() {
        final BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
        root.left = new BinaryTree.TreeNode(2);
        root.right = new BinaryTree.TreeNode(3);
        root.left.left = new BinaryTree.TreeNode(4);
        root.left.right = new BinaryTree.TreeNode(5);

        assertThat(diameterBinaryTree.best(root), equalTo(3));
    }

}