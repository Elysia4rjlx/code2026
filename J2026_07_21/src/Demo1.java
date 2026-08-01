import java.util.Scanner;


class Singleton{
    //借助 static
    //此时通过这样的方式，把实例创建出来

    private static Singleton instance = new Singleton();

    //如果想使用这个实例，就需要通过这个方法来获取
    public static Singleton getInstance(){
        return instance;
    }

    //还要防止程序员通过其他途径创建出多个实例
    //把类的构造方法设为private
    private Singleton(){}
}



public class Demo1 {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }
}