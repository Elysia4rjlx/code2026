


class Solution3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode parent = null;

        while (cur != null) {
            if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            } else {
                return remove(root, cur, parent);
            }
        }
        return root;
    }

    private TreeNode remove(TreeNode root, TreeNode cur, TreeNode parent) {
        if (cur.left == null) {
            if (root == cur) {
                return cur.right;
                //如果是删根节点，直接返回新的头
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (root == cur) {
                return cur.left;
                //如果是删根节点，直接返回新的头
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            TreeNode target = cur.right;
            TreeNode parentTarget = cur;

            while (target.left != null) {
                parentTarget = target;
                target = target.left;
            }

            cur.val = target.val;
            if (target == parentTarget.left) {
                parentTarget.left = target.right;
            } else {
                parentTarget.right = target.right;
            }
        }
        return root;
    }
}