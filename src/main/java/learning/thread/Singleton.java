package learning.thread;

public class Singleton {
    // 1）volatile禁止JVM指令重排优化
    // 2）进入主存读取该变量（保证变量可见性）
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public  static Singleton getUniqueInstance() {
        // 先判断对象是否已经实例过，没有实例化过才进入加锁代码
        // 此处主要是为了提高效率
        if (uniqueInstance == null) {
            // 类对象加锁
            // 此处为了防止多次创建实例
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
