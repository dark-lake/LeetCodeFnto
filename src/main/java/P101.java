

import java.util.LinkedList;
import java.util.List;

public class P101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        List<TreeNode> queue = new LinkedList<>();
        List<TreeNode> temp;
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = new LinkedList<>();
            for (TreeNode treeNode : queue) {
                if (treeNode != null) {
                    temp.add(treeNode.left);
                    temp.add(treeNode.right);
                }
            }
            // 判断是否对称, 如果对称那么queue.size()一定是偶数
            int startIndex = queue.size() / 2;
            int tempIndex = startIndex;
            for (int i = 1; i < queue.size() / 2 + 1; i++) {
                TreeNode t = queue.get(tempIndex++);
                TreeNode p = queue.get(startIndex - i);
                if (t == null) {
                    if (p != null) {
                        return false;
                    }
                } else {
                    if (p == null) {
                        return false;
                    } else {
                        if (t.val != p.val) {
                            return false;
                        }
                    }
                }
            }
            queue = temp;
        }
        return true;
    }

    public boolean isSymmetric1(TreeNode root) {
        if(root==null) return false;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right == null) return false;
        if (left == null) return false;
        if (left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }


    public static void main(String[] args) {
        P101 p101 = new P101();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(4);
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = right1;
        right.left = left2;
        right.right = right2;
        boolean symmetric = p101.isSymmetric1(root);
        System.out.println(symmetric);
    }
}
