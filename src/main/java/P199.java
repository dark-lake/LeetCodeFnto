import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P199 {

    public List<Integer> rightSideView(TreeNode root) {
        // 层次遍历,每次都拿到这一层的最后一个值即可
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        List<TreeNode> queue = new LinkedList<>();
        List<TreeNode> temp;
        queue.add(root);
        while(!queue.isEmpty()){
            temp = new LinkedList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode tn = queue.get(i);
                if(i==queue.size()-1) res.add(tn.val);
                if(tn.left!=null) temp.add(tn.left);
                if(tn.right!=null) temp.add(tn.right);
            }
            queue = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        P199 p199 = new P199();
    }
}
