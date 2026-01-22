import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] array = {99,4,3,1,6,9,4,2,9,3};
//        Sort.mergeSortNor(array);
        Sort.countSort(array);
        System.out.println(Arrays.toString(array));
    }
}
