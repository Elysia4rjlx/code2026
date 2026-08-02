
class Singletonlazy{
    private static Singletonlazy instance = null;

    public static Singletonlazy getInstance(){
        if (instance == null){
            instance = new Singletonlazy();
        }
        return instance;
    }

    private Singletonlazy(){};
}



public class Demo2 {
    public static void main(String[] args) {

    }
}