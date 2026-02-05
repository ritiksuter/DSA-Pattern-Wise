import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class TopDownDFS {
    void dfsDepth(TreeNode root, int depth) {
        if (root == null) return ;

        System.out.println("Node " + root.val + " at depth " + depth);
        dfsDepth(root.left, depth + 1);
        dfsDepth(root.right, depth + 1);
    }

    // Root to leaf Path Sum
    boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        sum -= root.val;

        if (root.left == null && root.right == null) {
            return sum == 0;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    void printPaths(TreeNode root, List<Integer> path) {
        if (root == null) return ;

        path.add(root.val);

        if (root.left == null && root.right == null) {
            System.out.println(path);
        }
        else {
            printPaths(root.left, path);
            printPaths(root.right, path);
        }
        path.remove(path.size() - 1);    // Backtrack
    }

    int maxRootToLeaf(TreeNode root, int currSum) {
        if (root == null) return Integer.MIN_VALUE;

        currSum += root.val;

        if (root.left == null && root.right == null) {
            return currSum;
        }

        return Math.max(maxRootToLeaf(root.left, currSum), maxRootToLeaf(root.right, currSum));
    }

    boolean hasSequence(TreeNode root, int[] seq, int index) {
        if (root == null || index >= seq.length) return false;

        if (root.val != seq[index]) return false;

        if (root.left == null && root.right == null && index == seq.length - 1) {
            return true;
        }

        return hasSequence(root.left, seq, index+1) || hasSequence(root.right, seq, index+1);
    }
}