class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    TreeNode root;

    public  static void preorder(TreeNode root) {
        if(root == null) return ;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(TreeNode root) {
        if(root == null) return ;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void postorder(TreeNode root) {
        if(root == null) return ;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void preorderIterative(TreeNode root) {
        if(root == null) return ;
    }
}

public class TreeTraversal {
    public static void main(String[] args) {
        
    }
}
