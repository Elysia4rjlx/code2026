import java.util.*;

public class DFS {

    // --- 1. 全局变量区 (大仓库) ---
    // res: 存放最终所有的结果（相册）
    List<List<Integer>> res = new ArrayList<>();
    // path: 存放当前正在走的路径（背包）
    // *技巧：用 LinkedList 是因为增删操作要在尾部进行，效率高
    LinkedList<Integer> path = new LinkedList<>();
    // used: 记录某个元素是否被使用过（打标记）
    // *注意：有些题目（如组合/子集）不需要这个，但全排列必须有
    boolean[] used;

    // --- 2. 主函数 (入口) ---
    public List<List<Integer>> permute(int[] nums) {
        // 初始化标记数组
        used = new boolean[nums.length];
        // 开启回溯之旅
        dfs(nums);
        return res;
    }

    // --- 3. 回溯核心函数 (递归) ---
    void dfs(int[] nums) {
        // 【第一步：终止条件】(什么时候拍照？)
        // 比如全排列，就是路径长度等于数组长度时
        if (path.size() == nums.length) {
            // *** 核心大坑 ***：必须 new 一个新的 ArrayList 拷贝当前路径
            // 如果写 res.add(path)，最后得到全是空的！
            res.add(new ArrayList<>(path));
            return;
        }

        // 【第二步：横向遍历】(在这个路口，有哪些选择？)
        for (int i = 0; i < nums.length; i++) {

            // 【剪枝】：如果这个数字刚才用过了，就跳过
            if (used[i]) {
                continue;
            }

            // === 核心三连 (进 -> 探 -> 退) ===

            // 1. 做选择 (进：存档)
            path.add(nums[i]);
            used[i] = true; // 标记占用

            // 2. 递归 (探：往深处走)
            dfs(nums);

            // 3. 撤销选择 (退：读档/恢复现场)
            path.removeLast(); // 吐出来
            used[i] = false;   // 撕掉标记
        }
    }

//    void test(){
//        //第一步：能不能停
//        if (){
//            记录结果
//            return;
//        }
//
//        //第二步：还有那些路可以走
//        for(每一个可能的选择){
//            //核心三连
//            path.add(选择);
//            test();
//            path.removeLast();
//        }


//    }
}