/**
 * 懒汉式单例（双重检查锁定 + volatile）
 *
 * 为什么要用 volatile？
 * 1. 禁止指令重排序：确保 instance = new SingletonLazy() 时，对象初始化先于引用赋值，
 *    避免其他线程拿到“半初始化”的实例。
 * 2. 保证可见性：volatile 强制将修改立即刷新到主内存，使其他线程能及时看到最新的 instance。
 *
 * 如果没有 volatile，双重检查锁定可能失效，导致多线程下返回未完全初始化的对象。
 */
class SingletonLazy {
    // volatile 是双重检查锁定的正确性保证
    private static volatile SingletonLazy instance = null;

    public static SingletonLazy getInstance() {
        // 第一次检查：避免每次调用都进入同步块，提高性能
        if (instance == null) {
            // 同步锁定类，确保只有一个线程能进入初始化
            synchronized (SingletonLazy.class) {
                // 第二次检查：防止在等待锁的过程中，其他线程已经完成了初始化
                if (instance == null) {
                    // 这里看似简单，实际包含三个步骤：
                    // 1. 分配内存空间
                    // 2. 初始化对象（执行构造方法）
                    // 3. 将内存地址赋值给 instance
                    // volatile 保证步骤 2 在步骤 3 之前完成，禁止指令重排序
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    private SingletonLazy() {
    }
}

public class Demo3 {
    public static void main(String[] args) {
        SingletonLazy s1 = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();
        System.out.println(s1 == s2); // 输出 true，表示同一个实例
    }
}