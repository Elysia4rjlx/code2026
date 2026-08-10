import java.io.File;
import java.io.IOException;

public class Demo2 {

    public static void main(String[] args) throws IOException {
        File file = new File("./1.txt");


        System.out.println("----创建前----");
        System.out.println(file.exists());

        //判断该文件是否为普通文件，如果不存在返回false
        System.out.println(file.isFile());

        //判断该文件是不是目录，不存在返回false
        System.out.println(file.isDirectory());


        System.out.println("----创建后----");
        //创建空白文件
        boolean newFile = file.createNewFile();
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        file.delete();

    }
}