package learning.reflection;

import org.junit.Test;

public class GetClassDemo {

    @Test
    // Class.class
    // 不会初始化
    public void test_1() {
        Class clazz = TestClass.class;
        System.out.println(clazz);
    }

    @Test
    // Class.forName()
    // 会初始化
    public void test_2() throws ClassNotFoundException {
        Class clazz = Class.forName("learning.reflection.TestClass");
        System.out.println(clazz);
    }

    @Test
    // instance.getClass()
    // 创建对象会初始化，但是getClass()不会初始化
    public void test_3() {
        TestClass testClass = new TestClass();
        Class clazz = this.getClass();
        System.out.println(clazz);
    }

    @Test
    // ClassLoader.getSystemClassLoader().loadClass()
    // 不会初始化
    public void test_4() throws ClassNotFoundException {
        Class clazz = ClassLoader.getSystemClassLoader().loadClass("learning.reflection.TestClass");
        System.out.println(clazz);
    }
}
