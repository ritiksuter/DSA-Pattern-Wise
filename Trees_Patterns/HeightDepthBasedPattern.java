class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode (int val) {
        this.val = val;
        left = right = null;
    }
}

class HeightDepthPattern {
    TreeNode root;

    TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        }
        else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    int heightEdges(TreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(heightEdges(root.left), heightEdges(root.right));
    }

    int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    int checkBalanced(TreeNode root) {
        if (root == null) return 0;

        int lh = checkBalanced(root.left);
        if (lh == -1) return -1;

        int rh = checkBalanced(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1) return -1;

        return 1 + Math.max(lh, rh);
    }

    boolean isBalanced(TreeNode root) {
        return checkBalanced(root) != -1;
    }

    static class Diameter {
        int dia = 0;

        int height(TreeNode root) {
            if (root == null) return 0;

            int lh = height(root.left);
            int rh = height(root.right);

            dia = Math.max(dia, lh + rh);

            return 1 + Math.max(lh, rh);
        }
    }

    void printDepth(TreeNode root, int depth) {
        if (root == null) return ;

        System.out.println("Node " + root.val + " -> Depth " + depth);
        printDepth(root.left, depth+1);
        printDepth(root.right, depth+1);
    }
}

public class HeightDepthBasedPattern {
    public static void main(String[] args) {
        HeightDepthPattern bst = new HeightDepthPattern();
        
        int[] values = {50, 30, 70, 20, 40, 60};

        for (int v : values) {
            bst.root = bst.insert(bst.root, v);
        }

        // System.out.println(bst.root.val);
        System.out.println(bst.heightEdges(bst.root));
        System.out.println(bst.minDepth(bst.root));
        System.out.println(bst.isBalanced(bst.root));
    }
}