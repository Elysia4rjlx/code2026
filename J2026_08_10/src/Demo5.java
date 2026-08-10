import java.io.File;

public class Demo5 {

    public static void main(String[] args) {
        File file = new File("./111/222/333/444");

        //mkdir  一次只能创建一级目录
        boolean result = file.mkdir();

        boolean results = file.mkdirs();
        System.out.println(results);

    }
}