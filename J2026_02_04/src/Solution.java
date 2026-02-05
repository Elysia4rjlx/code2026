import java.util.*;

public class Solution {

    // --- 1. 全局变量 ---
    // 结果集
    List<List<Integer>> res = new ArrayList<>();

    // 【重点】这里必须用 LinkedList，因为只有它才有 removeLast() 方法
    LinkedList<Integer> path = new LinkedList<>();

    // 标记数组
    boolean[] used;

    // --- 2. Main 函数 (程序的入口) ---
    public static void main(String[] args) {
        // 第一步：实例化对象 (创建一个 Solution 的实例)
        Solution sol = new Solution();

        // 第二步：准备数据
        int[] nums = {1, 2, 3};

        // 第三步：调用你的算法
        System.out.println("--- 算法开始运行 ---");
        List<List<Integer>> result = sol.permute(nums);

        // 第四步：打印结果
        System.out.println("--- 算法运行结束 ---");
        System.out.println("最终的全排列结果: " + result);
    }

    // --- 3. 初始化函数 ---
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(nums);
        return res;
    }

    // --- 4. DFS 回溯核心逻辑 ---
    private void dfs(int[] nums) {
        // 终止条件
        if (path.size() == nums.length) {
            // 调试打印：看看什么时候找到了一个完整排列
            System.out.println("📸 咔嚓！找到一个排列: " + path);
            res.add(new ArrayList<>(path)); // 记得拷贝！
            return;
        }

        // 遍历选择
        for (int i = 0; i < nums.length; i++) {
            // 剪枝：如果用过，跳过
            if (used[i]) {
                continue;
            }

            // === 进 ===
            path.add(nums[i]);
            used[i] = true;

            // 调试打印：看看放进去了什么
            System.out.println("👉 进: 放入 " + nums[i]);

            // === 探 (递归) ===
            dfs(nums);

            // === 退 (回溯) ===
            // 调试打印：看看拿出来了什么
            System.out.println("👈 退: 拿出 " + nums[i]);

            path.removeLast(); // 【LinkedList 专属方法】非常直观，把最后一个弹出来
            used[i] = false;
        }
    }
}