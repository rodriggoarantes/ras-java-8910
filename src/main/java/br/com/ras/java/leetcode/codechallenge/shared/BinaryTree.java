package br.com.ras.java.leetcode.codechallenge.shared;

public class BinaryTree {
    TreeNode root;

    public BinaryTree(int value) {
        this.add(value);
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public int diameter() {
        return diametro(root);
    }

    public void add(int value) {
        root = add(root, value);
    }

    private static int diametro(TreeNode treeNode) {
        if (treeNode == null) return 0;

        int countL = altura(treeNode.left);
        int countR = altura(treeNode.right);

        int diametroL = diametro(treeNode.left);
        int diametroR = diametro(treeNode.right);

        return Math.max(countL + countR, Math.max(diametroL, diametroR));
    }

    private static int altura(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return (1 + Math.max(altura(treeNode.left), altura(treeNode.right)));
    }

    private static TreeNode add(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.val) {
            node.left = add(node.left, value);
        } else if (value > node.val) {
            node.right = add(node.right, value);
        } else {
            return node;
        }
        return node;
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
