public class P543 {
    // 用来记录最终结果,其实就是以某一个结点为根它的左右子树的高度和, 但是要的是这个呃高度和最高的
    // 此时并不是根节点的左右子树高度和就是最大的
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTree1(root);
        return max;
    }

    public int diameterOfBinaryTree1(TreeNode root) {
        if(root==null) return 0;
        int l = diameterOfBinaryTree1(root.left);
        int r = diameterOfBinaryTree1(root.right);
        // 每求得一个子树的左右子树和就要更新一下最左右子树高度和这个值
        max = Math.max(max, l+r);
        return Math.max(l,r) + 1;
    }
}
