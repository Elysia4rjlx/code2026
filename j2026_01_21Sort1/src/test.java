import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] array = {4,2,61,3,24,99,1,33,32,66};
//        Sort.quickSort(array);
        Sort.quickSortNonRecursive(array);
        System.out.println(Arrays.toString(array));
    }

}
