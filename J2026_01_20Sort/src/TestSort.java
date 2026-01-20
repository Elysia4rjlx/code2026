import java.util.Arrays;
import java.util.Random;

public class TestSort {

    public static void testInsertSort(int[] array) {
        int[] copyArray = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.insertSort(copyArray);
        long endTime = System.currentTimeMillis();
        System.out.println("插入排序耗时：" + (endTime - startTime));
    }

    public static void testShellSort(int[] array) {
        int[] copyArray = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.shellSort(copyArray);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序耗时：" + (endTime - startTime));
    }

    public static void testSelectSort(int[] array) {
        int[] copyArray = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.selectSort(copyArray);
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序耗时：" + (endTime - startTime));
    }

    public static void testHeapSort(int[] array) {
        int[] copyArray = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.heapSort(copyArray);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排序耗时：" + (endTime - startTime));
    }
}
