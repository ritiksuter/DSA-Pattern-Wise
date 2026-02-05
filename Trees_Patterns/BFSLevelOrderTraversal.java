import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode (int val) {
        this.val = val;
        left = right = null;
    }
}

class BFSTraversal {
    void levelOrder(TreeNode root) {
        if (root == null) return ;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print(curr.val + " ");

            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right); 
        }
    }

    List<List<Integer>> levelOrderList(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            result.add(level);
        }
        return result;
    }

    static void reverseLevelOrder(TreeNode root) {
        if (root == null) return ;

        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            st.push(curr.val);

            if (curr.right != null) q.add(curr.right);
            if (curr.left != null) q.add(curr.left);
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}

public class BFSLevelOrderTraversal {
    public static void main(String[] args) {
        
    }
}