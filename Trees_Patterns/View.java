import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}


public class View {
    void leftView(TreeNode root) {
        if (root == null) return ;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (i == 0) System.out.print(curr.val + " ");
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
    }

    void leftViewDFS(TreeNode root, int level, List<Integer> res) {
        if (root == null) return ;

        if (level == res.size()) res.add(root.val);

        leftViewDFS(root.left, level + 1, res);
        leftViewDFS(root.right, level + 1, res);
    }

    void rightView(TreeNode root) {
        if (root == null) return ;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (i == size - 1) System.out.print(curr.val + " ");
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
    }

    void topView(TreeNode root) {
        if (root == null) return ;

        class Pair {
            TreeNode node;
            int hd;
            Pair(TreeNode n, int h) {
                node = n;
                hd = h;
            }
        }
        
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            map.putIfAbsent(p.hd, p.node.val);

            if (p.node.left != null) q.add(new Pair(p.node.left, p.hd - 1));
            if (p.node.right != null) q.add(new Pair(p.node.right, p.hd + 1));
        }

        for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }

    void bottomView(TreeNode root) {
        if (root == null) return ;

        class Pair {
            TreeNode node;
            int hd;
            Pair(TreeNode n, int h) {
                node = n;
                hd = h;
            }
        }
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            map.put(p.hd, p.node.val);

            if (p.node.left != null) q.add(new Pair(p.node.left, p.hd - 1));
            if (p.node.right != null) q.add(new Pair(p.node.right, p.hd + 1));
        }

        for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }

    void printLeftBoundary(TreeNode root) {
        if (root == null) return ;

        if (root.left != null) {
            System.out.print(root.val + " ");
            printLeftBoundary(root.left);
        }
        else if (root.right != null) {
            System.out.print(root.val + " ");
            printLeftBoundary(root.right);
        }
    }

    void printRightBoundary(TreeNode root) {
        if (root == null) return ;

        if (root.right != null) {
            printRightBoundary(root);
            System.out.print(root.val + " ");
        }
        else if (root.left != null) {
            printRightBoundary(root.left);
            System.out.print(root.val + " ");
        }
    }

    void printLeaves(TreeNode root) {
        if (root == null) return ;

        if (root.left == null && root.right == null) {
            System.out.print(root.val + " ");
            return ;
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }

    public void boundary(TreeNode root) {
        if (root == null) return ;

        System.out.print(root.val + " ");

        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }
}
