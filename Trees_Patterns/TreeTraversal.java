import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class BinarySearchTree {
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

    boolean search(TreeNode root, int key) {
        if (root == null) return false;
        if(root.val == key) return true;

        return key < root.val ? search(root.left, key) : search(root.left, key);
    }

    TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = delete(root.left, key);
        }
        else if (key > root.val) {
            root.right = delete(root.right, key);
        }
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            root.val = minValue(root.right);
            root.right = delete(root.right, root.val);
        }
        return root;
    }

    int minValue(TreeNode node) {
        int min = node.val;
        while (node.left != null) {
            min = node.left.val;
            node = node.left;
        }
        return min;
    }

    void inorder(TreeNode root) {
        if (root == null) return ;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    void preorder(TreeNode root) {
        if (root == null) return ;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    void postorder(TreeNode root) {
        if (root == null) return ;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    void levelOrder(TreeNode root) {
        if (root == null) return ;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    int height(TreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    int size(TreeNode root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    int findMin(TreeNode root) {
        if (root == null) throw new RuntimeException("Tree is Empty !");
        while (root.left != null) root = root.left;
        return root.val;
    }

    int findMax(TreeNode root) {
        if (root == null) throw new RuntimeException("Tree is Empty !");
        while (root.right != null) root = root.right;
        return root.val;
    }
}

public class TreeTraversal {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) {
            bst.root = bst.insert(bst.root, v);
        }

        System.out.print("Inorder: ");
        bst.inorder(bst.root);

        System.out.print("\nPreorder: ");
        bst.preorder(bst.root);

        System.out.print("\nPostorder: ");
        bst.postorder(bst.root);

        System.out.print("\nLevel Order: ");
        bst.levelOrder(bst.root);

        System.out.println("\nSearch 40: " + bst.search(bst.root, 40));
        System.out.println("Height: " + bst.height(bst.root));
        System.out.println("Size: " + bst.size(bst.root));
        System.out.println("Min: " + bst.findMin(bst.root));
        System.out.println("Max: " + bst.findMax(bst.root));

        bst.root = bst.delete(bst.root, 50);
        System.out.print("After deleting 50 (Inorder): ");
        bst.inorder(bst.root);
    }
}