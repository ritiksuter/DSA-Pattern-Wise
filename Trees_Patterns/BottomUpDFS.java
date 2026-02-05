class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BottomUpDFS {
    static class MaxPathSum {
        int maxSum = Integer.MIN_VALUE;

        int dfs(TreeNode root) {
            if (root == null) return 0;

            int left = Math.max(0, dfs(root.left));
            int right = Math.max(0, dfs(root.right));

            maxSum = Math.max(maxSum, root.val + left + right);

            return root.val + Math.max(left, right);
        }
    }

    static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return 1 + left + right;
    }

    boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}
