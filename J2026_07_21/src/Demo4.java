class Singletonlazyss {
    private static  volatile Singletonlazyss instance = null;//读优化

    public static Singletonlazyss getInstance(){
        if(instance == null){       //第一个条件判断要不要加锁  写优化
            synchronized(Singletonlazys.class){
                if (instance == null){  //第二个条件判断要不要new对象
                    instance = new Singletonlazyss();
                }
            }
        }
        return instance;
    }

    private  Singletonlazyss(){}

}


public class Demo4 {

}