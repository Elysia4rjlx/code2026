import java.io.File;
import java.util.Arrays;

public class Demo4 {

    public static void main(String[] args) {
        File file = new File("./");

        //通过List列出目录下的内容
        //每个元素，就是当前目录下的每一个文件或者目录的元素

        String[] List = file.list();
        System.out.println(List.length);
        System.out.println(Arrays.toString(List));

        // 通过 listFiles 列出目录下的内容
        // 每个元素, 就是当前目录下每个文件/目录的 File 对象
        File[] listFiles = file.listFiles();
        System.out.println(listFiles);
    }
}