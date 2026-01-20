public class Sort {

    /**
     * 插入排序
     * 时间复杂度：最好O(N)  最坏O(N*2)
     * 空间复杂度：O(1)
     * 数据越有序，越快
     * 稳定性：稳定
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > tmp){
                    array[j + 1] = array[j];
                }else {
//                    array[j + 1] = tmp;
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    /**
     * 希尔排序
     * 不稳定排序
     * 时间复杂度O(N ^ 1.25 - N ^1.3)
     * 空间复杂度：O(1)
     * 直接插入排序的优化，分组进行插入排序
     * @param array
     */
    public static void shellSort(int[] array){
        int gap = array.length;
        while (gap > 1){
            gap /= 2;
            shell(array,gap);
        }
    }

    private static void shell(int[] array, int gap) {

        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j-=gap) {
                if (array[j] > tmp){
                    array[j + gap] = array[j];
                }else {
//                    array[j + gap] = tmp;
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }

    /**
     * 选择排序
     * 时间复杂度：O(N*2)   无最好最坏情况
     * 空间复杂度：O(1)
     * 不稳定
     * @param array
     */
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if (i != minIndex){
                swap(array,i,minIndex);
            }
        }
    }

    private static void swap(int[] array, int i, int minIndex) {
        int tmp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = tmp;
    }

    /**
     * 堆排序
     * 时间复杂度：O(n * logN),对数据不敏感
     * 空间复杂度：O(1)
     * 不稳定
     * @param array
     */
    public static void heapSort(int[] array){
        createHeap(array);
        int end = array.length - 1;
        while (end > 0){
            swap(array,0,end);
            siftDown(array,0,end);
            end--;
        }

    }

    private static void createHeap(int[] array) {
        for (int parent = (array.length - 1 -1)/2;parent >= 0;parent-- ){
            siftDown(array,parent,array.length);
        }

    }

    private static void siftDown(int[] array, int parent, int length) {
        int child = 2 * parent + 1;
        while (child < length) {
            if (child + 1 < length && array[child] < array[child + 1]){
                child++;
            }
            if (array[child] > array[parent]){
                swap(array,child,parent);
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }
        }
    }


}

