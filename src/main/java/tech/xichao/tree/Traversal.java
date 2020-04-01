package tech.xichao.tree;

import java.util.Objects;
import java.util.Stack;

/**
 * 二叉树的遍历
 *
 * @author xichao
 * @date 20200330
 */
public class Traversal {

    public static void main(String[] args) {
        /**
         *         1
         *    2         3
         * 4     5   6      7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        preOrderRecursive(root);
        System.out.println();
        preOrderStack(root);

        System.out.println();
        midOrderRecursive(root);
        System.out.println();
        midOrderStack(root);

        System.out.println();
        postOrderRecursive(root);
        System.out.println();
        postOrderStack(root);
    }

    /**
     * 前序遍历 - 递归版
     */
    public static void preOrderRecursive(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        printNode(root);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    /**
     * 前序遍历 - 非递归版
     */
    public static void preOrderStack(TreeNode root) {
        Stack<TreeNode> treeStack = new Stack<>();
        TreeNode node = root;
        while (Objects.nonNull(node) || !treeStack.isEmpty()) {
            if (Objects.nonNull(node)) {
                printNode(node);
                treeStack.push(node);
                node = node.left;
            } else {
                node = treeStack.pop();
                node = node.right;
            }
        }

    }

    /**
     * 后序遍历 - 递归版
     */
    public static void postOrderRecursive(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        printNode(root);
    }

    /**
     * 后序遍历 - 非递归版
     */
    public static void postOrderStack(TreeNode root) {
        Stack<TreeNode> treeStack = new Stack<>();
        TreeNode node = root;
        while (Objects.nonNull(node) || !treeStack.isEmpty()) {
            if (Objects.nonNull(node)) {
                printNode(node);
                treeStack.push(node);
                node = node.left;
            } else {
                node = treeStack.pop();
                node = node.right;
            }
        }

    }

    /**
     * 中序遍历 - 递归版
     */
    public static void midOrderRecursive(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        midOrderRecursive(root.left);
        printNode(root);
        midOrderRecursive(root.right);
    }

    /**
     * 中序遍历 - 非递归版
     */
    public static void midOrderStack(TreeNode root) {
        Stack<TreeNode> treeStack = new Stack<>();
        TreeNode node = root;
        while (Objects.nonNull(node) || !treeStack.isEmpty()) {
            if (Objects.nonNull(node)) {
                treeStack.push(node);
                node = node.left;
            } else {
                node = treeStack.pop();
                printNode(node);
                node = node.right;
            }
        }

    }

    private static void printNode(TreeNode node) {
        System.out.print(node.val + ", ");
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
