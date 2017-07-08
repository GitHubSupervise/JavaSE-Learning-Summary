package org.demo.reflect.constructor;

import org.demo.reflect.bean.People;
import java.lang.reflect.Constructor;

/**
 * Created by Godql on 2017/7/8.
 * 动态操作构造方法
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = People.class;
        // 获取无参的构造方法
        Constructor<?> c1 = clazz.getConstructor();
        // 获取构造方法的名称
        System.out.println(c1.getName());
        // 获取一个私有并且带参数的构造方法
        Constructor<?> c2 = clazz.getDeclaredConstructor(String.class);

        // 可以通过构造方法实例化一个对象
        //（注意：如果默认有一个无参并且是公共的构造方法，
        // 那么可以直接使用class.newInstance()方法创建实例，
        // 如果构造方法是私有的，或者是带参数的，就必须先获取
        // Constructor对象，在通过这个对象来创建类实例）

        // 1.适用于无参并且是公共的构造方法
        /*
          Object instance = clazz.newInstance();
          System.out.println(instance);
         */

        // 2.适用于带参数或是私有的构造方法
        // 由于构造方法也可以私有化，所以必须先打开访问开关
        c2.setAccessible(true);
        Object instance = c2.newInstance("Godql");
        System.out.println(instance);

        // 获取所有public修饰的构造方法
        Constructor<?>[] cons = clazz.getConstructors();
        // 获取所有构造方法（包括私有的）
        Constructor<?>[] cons2 = clazz.getDeclaredConstructors();
    }
}
