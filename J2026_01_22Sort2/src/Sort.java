public class Sort {
    /**
     * 三数取中
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int getMidIndex(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;

        if (array[left] < array[right]) {
            if (array[mid] < array[left]) {
                return left;
            } else if (array[mid] > array[right]) {
                return right;
            } else {
                return mid; // 包含了 mid == left 或 mid == right 的情况
            }
        } else {
            if (array[mid] > array[left]) {
                return left;
            } else if (array[mid] < array[right]) {
                return right;
            } else {
                return mid; // 同样包含了相等的情况
            }
        }
    }

    private static int getMidIndex1(int[] array, int left, int right) {
        int mid = left + (right - left >>> 1);

        if (array[left] < array[mid]) {
            //意味着 Left < Mid。此时 Mid 要么是最大值，要么是中间值
            if (array[mid] < array[right]) {
                return mid;
            } else {
                //Left < Mid 且 Right <= Mid,说明 Mid 是最大的或者并列
                //中间值就在 Left 和 Right 之间产生，谁大谁就是中间值
                return array[left] < array[right] ? right : left;
            }
        } else {
            //意味着 Mid <= Left。此时 Left 要么是最大值，要么是中间值
            if (array[left] < array[right])
                return left;
            else {
                //Mid <= Left 且 Right <= Left。说明 Left 是最大的或者并列
                return array[mid] < array[right] ? right : mid;
            }
        }
    }






    
    /**
     * 归并排序
     * 时间复杂度：O(N*logN)
     * 空间复杂度O(N)
     * 稳定
     *
     * @param array
     */
    public static void mergeSort(int[] array) {
        mergeChird(array, 0, array.length - 1);
    }

    private static void mergeChird(int[] array, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        //先分解
        mergeChird(array, left, mid);
        mergeChird(array, mid + 1, right);

        //再合并
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int s1 = left;
        int e1 = mid;

        int s2 = mid + 1;
        int e2 = right;

        //临时数组
        int[] tmpArray = new int[right - left + 1];
        //临时下标
        int k = 0;

        while (s1 <= e1 && s2 <= e2) {
            if (array[s1] <= array[s2]) {
                tmpArray[k] = array[s1];
                k++;
                s1++;
            } else {
                tmpArray[k] = array[s2];
                k++;
                s2++;
            }
        }

        //当有一方条件不成立时，说明某一方还有多余的数据
        while (s1 <= e1) {
            tmpArray[k] = array[s1];
            k++;
            s1++;
        }

        while (s2 <= e2) {
            tmpArray[k] = array[s2];
            k++;
            s2++;
        }

        //将临时数组拷贝回去
        for (int i = 0; i < k; i++) {
            array[i + left] = tmpArray[i];
        }
    }


    public static void mergeSortNor(int[] array) {
        int gap = 1;
        while (gap < array.length) {

            for (int i = 0; i < array.length; i = i + 2 * gap) {
                int left = i;
                int mid = left + gap - 1;
                if (mid >= array.length) {
                    mid = array.length - 1;
                }
                int right = mid + gap;
                if (right >= array.length) {
                    right = array.length - 1;
                }
                merge(array, left, mid, right);
            }
            gap *= 2;
        }
    }

    /**
     * 计数排序
     * 集中在某一个范围的数据
     * 时间复杂度：O(MAX(N,范围))
     * 空间复杂度：O(范围)
     * 稳定
     *
     * @param array
     */
    public static void countSort(int[] array) {
        //求出array数组的最大最小值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        //获取计数数组的长度
        int len = max - min + 1;
        int[] count = new int[len];

        //循环原数组，开始计数
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - min;
            count[index]++;
        }

        //遍历计数数组，开始排序，将排序好的书覆盖回原数组
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                array[k] = i + min;
                k++;
                count[i]--;
            }
        }


    }


}
