import java.io.File;
import java.io.IOException;

public class Demo1 {

    public static void main(String[] args) throws IOException {

//        File file = new File("D:\\1计算机\\Java\\1.txt");
        //相对路径
        File file = new File("./1.txt");

        // 获取到当前文件所在的目录
        System.out.println("获取到当前文件所在的目录:   " + file.getParent());

        // 获取到当前的文件名
        System.out.println("获取到当前的文件名:  " + file.getName());

        //获取到当前的文件路径
        System.out.println("获取到当前的文件路径:  " + file.getAbsolutePath());

        //获取文件的整理后的绝对路径
        System.out.println("获取文件的整理后的绝对路径:  " + file.getCanonicalPath());
    }
}