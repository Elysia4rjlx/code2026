import java.util.Arrays;

public class test {
    public static void main1(String[] args) {
        int[] array = {4,2,61,3,24,99,1,33,32,66};
        Sort.heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = new int[10_0000];
        CreatOrder.randomOrder(array);
        TestSort.testInsertSort(array);
        TestSort.testShellSort(array);
        TestSort.testSelectSort(array);
        TestSort.testHeapSort(array);
    }
}
