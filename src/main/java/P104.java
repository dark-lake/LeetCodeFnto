import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class P104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int ldep = maxDepth(root.left);
        int rdep = maxDepth(root.right);
        return ldep > rdep ? ldep + 1 : rdep + 1;
    }

    public int maxDepthQueue(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<>() {{
            add(root);
        }}, tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }


    public static void main(String[] args) {
        P104 p104 = new P104();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode tn = new TreeNode(3);
        right.left = tn;
        root.right = right;
        int i = p104.maxDepthQueue(root);
        System.out.println(i);
    }
}
