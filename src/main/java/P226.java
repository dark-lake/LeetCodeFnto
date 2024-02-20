public class P226 {
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            invertTree1(root);
        }
        return root;
    }

    public void invertTree1(TreeNode root){
        if(root==null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree1(root.left);
        invertTree1(root.right);
    }

    public static void main(String[] args) {
        P226 p226 = new P226();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode treeNode = p226.invertTree(root);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right.val);
    }
}
