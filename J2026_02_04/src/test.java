import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;


    public List<List<Integer>> permute(int[]nums){
        used = new boolean[nums.length];
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums){
        if(path.size() == nums.length){
            System.out.println("  达到终点，拍照: " + path); // 【打印点1】
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            path.add(nums[i]);
            used[i] = true;

            System.out.println("进: 放入 " + nums[i] + "，当前 path: " + path); // 【打印点2】

            dfs(nums); // 进入下一层

            // --- 只有从下一层回来，才会执行下面这句 ---
            System.out.println("退: 拿出 " + nums[i] + "，准备试下一个"); // 【打印点3】

            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        // 第二步：准备数据
        int[] nums = {1,2,3};

        // 第三步：调用你的算法
        System.out.println("--- 算法开始运行 ---");
        List<List<Integer>> result = sol.permute(nums);

        // 第四步：打印结果
        System.out.println("--- 算法运行结束 ---");
        System.out.println("最终的全排列结果: " + result);
    }
}
