public class P230 {
    // count用来记录当前是第几个结点
    int count = 1;
    // K 就是k
    int K = 0;
    // res 第k个结点的值
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        kthSmallest1(root);
        return res;

    }

    public void kthSmallest1(TreeNode root){
        // 中序遍历,直接从小到大,如果是第k个就直接结束了
        if(root==null) return;
        kthSmallest1(root.left);
        if(count++ == K){
            res = root.val;
            return;
        }
        kthSmallest1(root.right);
    }

    public static void main(String[] args) {
        P230 p230 = new P230();
    }
}
