package learning.reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectDemo {
    @Test
    public void test() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        /*
         * 获取类的Class对象，并且创建类实例
         */
        Class<?> clazz = TestClass.class;
        TestClass instance = (TestClass) clazz.newInstance();
        System.out.println();


        /*
         * 获取所有类中所有定义的方法
         */
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print(method.getName());
            System.out.println(Arrays.deepToString(method.getParameterTypes()));
        }
        System.out.println();


        /*
         * 获取指定方法并调用
         */
        Method method = clazz.getDeclaredMethod("publicMethod", String.class);
        method.invoke(instance, "PublicFunc");
        System.out.println();


        /*
         * 调用 private 方法
         */
        Method privateMethod = clazz.getDeclaredMethod("privateMethod");
        // 为了调用private方法，需要取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(instance);
        System.out.println();


        /*
         * 获取所有类中所有定义的方法
         */
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + "---" + field.getType());
        }
        System.out.println();


        /*
         * 获取指定参数并对参数进行修改
         */
        Field privateField = clazz.getDeclaredField("value");
        // 为了对类中的参数进行修改，需要取消安全检查
        privateField.setAccessible(true);
        privateField.set(instance, "NewValue");
        privateMethod.invoke(instance);

        Field publicField = clazz.getDeclaredField("pubVal");
        // 为了对类中的参数进行修改，需要取消安全检查
        publicField.setAccessible(true);
        publicField.set(instance, "NewPubVal");
        System.out.println(instance.pubVal);
    }
}
