import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 存放结果
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // 存放每一层的
        List<Integer> temp;
        // 队列
        List<TreeNode> q = new LinkedList<>();
        // 替换队列
        List<TreeNode> tempq;
        // 加入根结点
        q.add(root);
        while (!q.isEmpty()) {
            tempq = new ArrayList<>();
            temp = new ArrayList<>();
            for (TreeNode tn : q) {
                if (tn != null) {
                    // 将队列中的每个结点的值加入到list中
                    temp.add(tn.val);
                    // 替换队列为下一层的结点队列
                    if (tn.left != null) tempq.add(tn.left);
                    if (tn.right != null) tempq.add(tn.right);
                }
            }
            // 将这一层的加入到结果list中
            res.add(temp);
            // 修改队列对象
            q = tempq;

        }
        return res;
    }
}
