
class Solution1 {
    public class TreeNode {
        int val;
        Solution1.TreeNode left;
        Solution1.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        TreeNode cur = root;
        while(cur != null){
            if(cur.val < val){
                cur = cur.right;
            }else if(cur.val > val){
                cur = cur.left;
            }else{
                return cur;
            }
        }
        return null;
    }
}