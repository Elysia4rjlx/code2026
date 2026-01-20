import java.util.Random;

public class CreatOrder {
    //顺序
    public static void order(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }
    //逆序
    public static void notOrder(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
    }
    //随机
    public static void randomOrder(int[] array){
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10_0000);
        }
    }
}
