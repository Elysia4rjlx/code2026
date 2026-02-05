public class PureDFS {
    // 定义一个简单的二叉树节点
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // --- 单纯的 DFS ---
    public void dfs(TreeNode root) {
        // 1. 终止条件（走到空节点就回头）
        if (root == null) {
            return;
        }

        // 2. 处理当前节点（比如：打印它）
        // 这里不需要 add 进列表，也不需要记录状态，就是看一眼
        System.out.println("我到了节点：" + root.val);

        // 3. 递归（一条道走到黑）
        // 去左边看看
        dfs(root.left);
        // 去右边看看
        dfs(root.right);
        
        // 【重点】：你看，这里没有 remove/撤销 的操作！
        // 因为我只是来旅游的，看完左边去看右边，不需要把左边“抹杀”掉。
    }
}