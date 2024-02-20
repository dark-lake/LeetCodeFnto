import com.sun.source.tree.Tree;

public class P968 {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        int i = test1(root);
        // 头结点没有处理,这里处理一下,如果是0那就res++
        if(i==0) res++;
        return res;
    }

    public int test1(TreeNode root) {
        // 空节点，该节点有覆盖
        if (root == null) return 2;
        int left = test1(root.left);
        int right = test1(root.right);

        // 情况1
        // 左右节点都有覆盖
        if (left == 2 && right == 2) return 0;

        // 情况2
        // left == 0 && right == 0 左右节点⽆覆盖
        // left == 1 && right == 0 左节点有摄像头，右节点⽆覆盖
        // left == 0 && right == 1 左节点有⽆覆盖，右节点摄像头
        // left == 0 && right == 2 左节点⽆覆盖，右节点覆盖
        // left == 2 && right == 0 左节点覆盖，右节点⽆覆盖
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        // left == 1 && right == 2 左节点有摄像头，右节点有覆盖
        // left == 2 && right == 1 左节点有覆盖，右节点有摄像头
        // left == 1 && right == 1 左右节点都有摄像头
        if(left == 1 || right == 1) return 2;

        // 这里不会走
        return -1;

    }


    public static void main(String[] args) {
        P968 p968 = new P968();
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(0);
//        TreeNode t5 = new TreeNode(0);
        t1.left = t2;
        t1.right = t3;
        t3.right = t4;
//        t4.right = t5;
        System.out.println(p968.minCameraCover(t1));
    }
}
