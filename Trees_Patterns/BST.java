class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BST {
    boolean search(TreeNode root, int key) {
        if (root == null) return false;

        if (root.val == key) return true;

        if (key < root.val) return search(root.left, key);
        else return search(root.right, key);
    }

    TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) root.left = insert(root.left, val);
        else if (val > root.val) root.right = insert(root.right, val);

        return root;
    }

    boolean validate(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }

    static int count = 0;
    static int result = -1;

    void kthSmallest(TreeNode root, int k) {
        if (root == null) return ;

        kthSmallest(root.left, k);

        count++;
        if (count == k) {
            result = root.val;
            return ;
        }
        kthSmallest(root.right, k);
    }

    TreeNode lca(TreeNode root, int p, int q) {
        if (root == null) return null;

        if (p < root.val && q < root.val) {
            return lca(root.left, p, q);
        }

        if (p > root.val && q > root.val) {
            return lca(root.right, p, q);
        }
        return root;
    }
}