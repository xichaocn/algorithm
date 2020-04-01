package tech.xichao.tree;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
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

        System.out.println("前序遍历:::");
        preOrderRecursive(root);
        System.out.println();
        preOrderStack(root);

        System.out.println();
        System.out.println("中序遍历:::");
        midOrderRecursive(root);
        System.out.println();
        midOrderStack(root);

        System.out.println();
        System.out.println("后序遍历:::");
        postOrderRecursive(root);
        System.out.println();
        postOrderStack(root);

        System.out.println();
        System.out.println("层序遍历:::");
        levelTraversal(root);
        System.out.println();

        System.out.println(depth(root));
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
     * 后序遍历递归定义：先左子树，后右子树，再根节点。
     * 从栈中拿出的节点：只有当是叶子节点（说明已经到底了）或当上一个节点为我的子节点时（说明子节点已经遍历完了）才出栈并打印；
     *                如果不是就先入栈右子节点、再入栈左子节点（因为栈是后入先出）。
     */
    public static void postOrderStack(TreeNode root) {
        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);
        TreeNode node, pre = null;

        while (!treeStack.empty()) {
            node = treeStack.peek();
            if ((Objects.isNull(node.left) && Objects.isNull(node.right))
                    || (Objects.nonNull(pre) && (pre == node.left || pre == node.right))) {
                treeStack.pop();
                printNode(node);
                pre = node;
            } else {
                if (Objects.nonNull(node.right)) {
                    treeStack.push(node.right);
                }
                if (Objects.nonNull(node.left)) {
                    treeStack.push(node.left);
                }
            }
        }
    }

    /**
     * 层序遍历
     * 广度优先遍历，使用队列
     */
    public static void levelTraversal(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        TreeNode node;
        while (!q.isEmpty()) {
            node = q.poll();
            printNode(node);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    /**
     * 树的深度
     */
    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left) + 1, depth(root.right) + 1);
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

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

}
