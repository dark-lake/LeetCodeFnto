import javax.swing.tree.TreeCellRenderer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 每次的新结点
        TreeNode root = new TreeNode();
        int length = nums.length;
        if(length == 0) return null;
        if(length == 1) {
            root.val = nums[0];
            return root;
        }
        // 循环处理左子树
        int[] left = Arrays.copyOfRange(nums, 0, length / 2);
        // 加1是跳过根节点
        int[] right = Arrays.copyOfRange(nums, length/2+1, length);
        root.val = nums[length/2];
        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
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
        P108 p108 = new P108();
        int[] test = {-10,-3,0,5,9};
        TreeNode treeNode = p108.sortedArrayToBST(test);
        printTree(treeNode);

    }
}
