class Singleton {

    private static Singleton instance = new Singleton();//通过static把实例创建出来

    //如果想使用这个实例，必须通过这个方法来获取
    public static Singleton getInstance(){
        return instance;
    }

    //不允许外部自己创建,把类的构造方法设为private
    private Singleton(){};
}
public class Demo1 {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }
}