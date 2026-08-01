import java.util.Scanner;

class Singletonlazy {
    private static Singletonlazy instance = null;

    public static Singletonlazy getInstance() {
        if (instance == null) {
            instance = new Singletonlazy();
        }
        return instance;
    }

    private Singletonlazy(){}
}


public class Demo2 {

}