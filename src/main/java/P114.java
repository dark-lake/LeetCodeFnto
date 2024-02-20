import java.util.ArrayList;
import java.util.List;

public class P114 {
    List<TreeNode> container = new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root==null) return;
        // 用一个list保存前序遍历的每个TreeNode
        pre(root);
        TreeNode temp = root;
        temp.right = null;
        temp.left = null;
        // 遍历这个container,把一个结点都接到root的后边就OK了
        // 从1开始,要跳过root本身
        for (int i = 1; i < container.size(); i++) {
            temp.right = container.get(i);
            temp.left = null;
            temp = temp.right;
        }
    }
    public void pre(TreeNode root){
        if(root==null) return;
        container.add(root);
        pre(root.left);
        pre(root.right);
    }

    public static void main(String[] args) {
        P114 p114 = new P114();
    }
}
