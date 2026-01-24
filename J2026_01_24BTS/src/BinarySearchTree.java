public class BinarySearchTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root;

    public boolean search(int val) {
        if (root == null) {
            return false;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < val) {//目标小，去左找；目标大，去右挂
                cur = cur.right;//当前值比目标小，说明目标大，往右走
            } else if (cur.val > val) {
                cur = cur.left;//当前值比目标大，说明目标小，往左走
            } else {
                return true;
            }
        }
        return false;

    }

    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;//必须要 return
        }
        //双指针
        TreeNode cur = root;
        TreeNode parent = null;

        //找到插入的位置
        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                //相同的值不插入
                return;
            }
        }

        //循环结束后找到位置，new一个新节点出来
        TreeNode newNode = new TreeNode(val);
        if (parent.val < val) {
            //parent.val < val 说明新来的大，放右边
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }

    }

    public void remove(int val) {
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
                removeNode(cur, parent);
                return;
            }
        }
    }

    /**
     * 删除节点
     *
     * @param cur    要删除的节点
     * @param parent 要删除的节点的父亲节点
     */
    private void removeNode(TreeNode cur, TreeNode parent) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            //左右双全 (cur.left != null 且 cur.right != null)
            //这种情况下不能直接删
            //替换法 找一个比左边都大，比右边都小的节点来代替被删节点
            TreeNode target = cur.right;
            TreeNode targetParent = cur;//初始值必须是 cur，防止右子树没有左孩子的情况

            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }

            cur.val = target.val;
            //这个时候 target 是右子树里的最小值，所以它可能有一个右孩子
            if (target == targetParent.right) {
                targetParent.right = target.right;
            } else {
                targetParent.left = target.right;
            }
        }

    }


}
