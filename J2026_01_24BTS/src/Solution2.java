




class Solution2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        TreeNode cur = root;
        TreeNode parent = null;

        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                return cur;
            }
        }

        TreeNode newNode = new TreeNode(val);
        if (parent.val < val) {
            parent.right = newNode;
            return root;
        } else {
            parent.left = newNode;
            return root;
        }

    }
}