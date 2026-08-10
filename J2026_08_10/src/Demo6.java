import java.io.File;

public class Demo6 {

    public static void main(String[] args) {

//         src => source
//        File fileSrc = new File("./111");
//        // dest => destination
//        File fileDest = new File("./11111");
//
//        // 把 1.txt 重命名成 2.txt
//        fileSrc.renameTo(fileDest);
        // 移动, 就是把 dest 的路径写到其他的目录中即可

        File fileSrc = new File("./1.txt");

        File fileDest = new File("./11111/1.txt");

        fileSrc.renameTo(fileDest);
    }
}