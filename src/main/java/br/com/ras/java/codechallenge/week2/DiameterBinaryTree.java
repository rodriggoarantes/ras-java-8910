package br.com.ras.java.codechallenge.week2;

/**
 * Diameter of Binary Tree
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterBinaryTree {

    public int solution(TreeNode root) {
        final BinaryTree tree = new BinaryTree(root);
        return tree.diameter();
    }

    int ans;
    public int best(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }

    public static class BinaryTree {
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
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
