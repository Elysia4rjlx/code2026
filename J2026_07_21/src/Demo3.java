class Singletonlazys {
    private static Singletonlazys instance = null;

    public static Singletonlazys getInstance(){
        if(instance == null){       //第一个条件判断要不要加锁  写优化
            synchronized(Singletonlazys.class){
                if (instance == null){  //第二个条件判断要不要new对象
                    instance = new Singletonlazys();
                }
            }
        }
        return instance;
    }

    private  Singletonlazys(){}

}


public class Demo3 {

}