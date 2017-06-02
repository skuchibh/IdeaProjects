package task;

//TREES IMPLEMENTATIONS

import lib.utils.InputReader;
import lib.utils.OutputWriter;

import java.util.LinkedList;
import java.util.Queue;

public class Task {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        BinaryTree tree = new BinaryTree(31);
        tree.root.left = new TreeNode(16);
        tree.root.right = new TreeNode(52);
        tree.root.left.left = new TreeNode(7);
        tree.root.left.right = new TreeNode(24);
        tree.root.left.right.left=new TreeNode(19);
        tree.root.left.right.right=new TreeNode(29);


        out.println(getDiameter(tree.root));
    }

    static int getHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    static int getDiameter(TreeNode node) { //O(n^2) complexity.
        if(node==null)return 0;
        int rootd = getHeight(node.left) + getHeight(node.right) + 1;
        int leftd = getDiameter(node.left);
        int rightd = getDiameter(node.right);
        return Math.max(rootd,Math.max(leftd,rightd));
    }

    static void deleteTree(TreeNode node, OutputWriter out) {
        if (node == null) return;
        deleteTree(node.left, out);
        deleteTree(node.right, out);
        out.println("Deleted Node is " + node.data);
        node = null;
    }

    static void printLevelOrder(BinaryTree tree, OutputWriter out) {
        if (tree.root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(tree.root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
            out.print(temp.data + " ");
        }
    }

    static void InOrder(TreeNode node, OutputWriter out) {
        if (node == null) return;
        InOrder(node.left, out);
        out.print(node.data + " ");
        InOrder(node.right, out);
    }

    static void PostOrder(TreeNode node, OutputWriter out) {
        if (node == null) return;
        PostOrder(node.left, out);
        PostOrder(node.right, out);
        out.print(node.data + " ");
    }

    static void PreOrder(TreeNode node, OutputWriter out) {
        if (node == null) return;
        out.print(node.data + " ");
        PreOrder(node.left, out);
        PreOrder(node.right, out);
    }

    static class BinaryTree {
        TreeNode root;

        public BinaryTree(int n) {
            root = new TreeNode(n);
        }
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int n) {
            data = n;
            left = right = null;
        }
    }
}
