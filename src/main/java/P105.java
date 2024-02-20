import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 递归的通过二叉树,通过不断切分其左右两个数组
        if (preorder.length == 0) {
            // 先序遍历的数组为空
            return null;
        }
        if (inorder.length == 0) {
            // 中序遍历的数组为空
            return null;
        }
        // 构造root结点
        TreeNode root = new TreeNode();
        // 去中序遍历数组中找到这root的位置,并切分
        int[] inLeft = new int[0], inRight = new int[0];
        int isFind = 0;
        for (int j = 0; j < preorder.length; j++) {
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == preorder[j]) {
                    root.val = preorder[j];
                    preorder = Arrays.copyOfRange(preorder, j + 1, preorder.length);
                    inLeft = Arrays.copyOfRange(inorder, 0, i);
                    inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                    isFind = 1;
                    break;
                }
            }
            if(isFind==1) break;
        }

        root.left = buildTree(preorder, inLeft);
        root.right = buildTree(preorder, inRight);
        return root;
    }

    public static void printTree(TreeNode root){
        List<TreeNode> queue = new LinkedList<>();
        List<TreeNode> temp;
        queue.add(root);
        while(!queue.isEmpty()){
            temp = new LinkedList<>();
            for (TreeNode treeNode : queue) {
                if(treeNode!=null){
                    // 打印出来每个值
                    System.out.println(treeNode.val);
                    // 让这些值的左右结点入队
                    temp.add(treeNode.left);
                    temp.add(treeNode.right);
                }
            }
            queue = temp;
        }
    }

    public static void main(String[] args) {
        P105 p105 = new P105();
        int[] test1 = {1,2,3};
        int[] test2=  {2,1,3};
        TreeNode treeNode = p105.buildTree(test1, test2);
        printTree(treeNode);
    }
}
