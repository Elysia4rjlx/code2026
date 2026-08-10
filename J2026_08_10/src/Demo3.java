import java.io.File;
import java.util.Scanner;

public class Demo3 {

    public static void main(String[] args) {
        File file = new File("./1.txt");

        //对文件进行删除
//        boolean result = file.delete();
//        System.out.println("是否成功删除：  " + result);

//      //等当前线程结束后执行删除操作
        file.deleteOnExit();
        Scanner sc = new Scanner(System.in);

        System.out.println("输入任意键后继续、、、");
        sc.next();
    }
}