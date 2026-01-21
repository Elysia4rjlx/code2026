import java.util.Stack;

public class Sort {
    /**
     * 冒泡排序
     * 时间复杂度：O(N^2)
     * 优化后最好情况O(1)
     * 空间复杂度：O(1)
     * 稳定
     */
    public static void bubbleSort(int[] array) {
        //i趟数
        for (int i = 0; i < array.length - 1; i++) {
            //
            boolean flg = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flg = true;
                }
            }
            if (!flg) {
                break;
            }
        }
    }

    private static void swap(int[] array, int i, int minIndex) {
        int tmp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = tmp;
    }

    //找好基准值，然后划分区域，排好当前区域，接下来去递归左右两个区域，
    // 直到元素为一个时，这个时候为有序

    /**
     * 快速排序
     * 选一个基准，把比它小的甩左边，比它大的甩右边，然后分头行动。
     * 时间复杂度：平均 O(N log N)，最坏情况（已经有序）会退化成 O(N^2)
     * 不稳定
     *
     * @param array
     */
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);

    }

    private static void quick(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(array, start, end);
        quick(array, start, pivot - 1);
        quick(array, pivot + 1, end);

    }

    /**
     * 划分待排序的序列
     * Hoare 法
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int partition1(int[] array, int left, int right) {
        int i = left;
        //记录基准值的初始位置
        int tmp = array[left];
        //选最左边的元素作为“基准值”


        while (left < right) {
            // 右指针先走
            // 只要右边对应的值 >= 基准值，就继续往左走，直到找到一个“比基准值小”的数
            while (left < right && array[right] >= tmp) {
                right--;
            }
            // 左指针后走
            // 只要左边对应的值 <= 基准值，就继续往右走，直到找到一个“比基准值大”的数
            while (left < right && array[left] <= tmp) {
                left++;
            }
            // 两人都停下了，说明 right 找到了小的，left 找到了大的
            // 交换它俩的位置，把小的扔左边，大的扔右边
            swap(array, left, right);

        }
        // 相遇了 (left == right)
        // 把基准值 tmp 归位到它最终应该在的地方 (相遇点)
        swap(array, left, i);
        return left;
    }

    /**
     * 划分待排序的序列
     * 挖坑法
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int partition2(int[] array, int left, int right) {

        // 选基准，挖出第一个坑
        int key = array[left];

        while (left < right) {
            // 右边先走，找比 key 小的数
            while (left < right && array[right] >= key) {
                right--;
            }
            // 找到后，直接填到左边的坑里
            // 填完之后，array[right] 就成了新坑（逻辑上）
            array[left] = array[right];
            // 左边后走，找比 key 大的数
            while (left < right && array[left] <= key) {
                left++;
            }
            array[right] = array[left];
        }
        //最后相遇的位置，就是 key 的归宿
        array[left] = key;

        return left;// 返回基准值的位置

    }

    /**
     * 划分待排序的序列
     * 前后指针法
     * prev 以及它左边的位置（除了 key），全都是比 key 小的数
     * cur 负责往后走，去判断每一个未知的数字是“大”还是“小”
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] array, int left, int right) {
        int prev = left;
        int cur = left + 1;
        //prev 指向 0 (基准值位置)，cur 指向 1 (下一个)。

        int key = array[left];

        //只有当 cur 遇到比 key 小的数时，才需要处理
        while (cur <= right) {
            //  核心判断：只在遇到“小的”时候处理
            // if (array[cur] < key && ++prev != cur)
            // 条件 A: array[cur] < key  -> 找到了属于左边的数
            // 条件 B: ++prev != cur     -> 这是一个优化。
            //        如果 prev 紧贴着 cur (中间没夹着大数)，比如开头全是小的，
            //        那 prev 往前走一步就撞上 cur 了，自己换自己没必要。
            //        只有当 prev 和 cur 之间有空隙（夹着大数）时，才需要真正的交换。
            if (array[cur] < key) {
                prev++;
                if (prev != cur) {
                    swap(array, cur, prev);
                }
            }
            //不管是不是比 key 小，cur 都要继续往后走，去检查下一个数
            cur++;
        }
        // 循环结束，prev 指向的是最后一个比 key 小的数
        // 把基准值(key)换到这里，让它居中
        swap(array, left, prev);
        return prev;

    }


    public static void quickSortNonRecursive(int[] array){

        Stack<Integer> stack = new Stack<>();

        int start = 0;
        int end = array.length - 1;
        stack.push(start);
        stack.push(end);

        while (!stack.empty()){
            int right = stack.pop();
            int left = stack.pop();

            int pivot = partition(array,left,right);

            if (pivot + 1 < right){
                stack.push(pivot + 1);
                stack.push(right);
            }
            if (pivot - 1 > left){
                stack.push(left);
                stack.push(pivot - 1);
            }
        }
    }
}


























