import java.util.ArrayList;
import java.util.List;

public class P94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalT(root, res);
        return res;
    }

    public void inorderTraversalT(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorderTraversalT(root.left, res);
            res.add(root.val);
            inorderTraversalT(root.right, res);
        }
    }

    public static void main(String[] args) {
        P94 p94 = new P94();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode tn = new TreeNode(3);
        right.left = tn;
        root.right = right;
        List<Integer> integers = p94.inorderTraversal(root);
        System.out.println(integers);

    }
}