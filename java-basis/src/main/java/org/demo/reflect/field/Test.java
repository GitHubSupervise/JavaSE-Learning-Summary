package org.demo.reflect.field;

import org.demo.reflect.anno.MyAnno;
import org.demo.reflect.bean.People;
import java.lang.reflect.Field;

/**
 * Created by Godql on 2017/7/8.
 * 动态操作属性
 */
public class Test {
    public static void main(String[] args) throws Exception {
        // 在反射操作之前的第一步，就是要先获取Class对象
        Class<?> clazz = People.class;
        // 根据Class对象创建一个实例
        Object instance = clazz.newInstance();
        // 获取指定的属性
        Field f1 = clazz.getField("userName");
        // 获取属性的值,get方法需要传入一个当前类的实例
        Object value = f1.get(instance);
        System.out.println(value);

        // 通过反射给属性赋值
        // 第一个参数是当前类的实例，第二个参数是要赋予的值
        f1.set(instance, "ls");
        value = f1.get(instance);
        System.out.println(value);

        // 获取一个私有的属性
        // 如果需要访问和操作私有的成员，必须打开访问开关
        // 打开访问开关其实就是破坏封装
        Field f2 = clazz.getDeclaredField("age");
        // 强制打开访问权限
        f2.setAccessible(true);
        Object value2 = f2.get(instance);
        System.out.println(value2);
        f2.set(instance, 30);
        value2 = f2.get(instance);
        System.out.println(value2);

        // 获取属性的名称
        System.out.println(f1.getName());
        System.out.println(f2.getName());

        // 获取属性的类型
        System.out.println(f1.getType());
        System.out.println(f2.getType());

        // 获取所有公有的属性(包括继承自父类的公有属性)
        Field[] fs1 = clazz.getFields();
        // 获取本类所有的属性（包括共有和私有的，但是不包括父类的）
        Field[] fs2 = clazz.getDeclaredFields();

        // 判断当前属性上是否定义了注解
        System.out.println(f1.isAnnotationPresent(MyAnno.class));
        System.out.println(f2.isAnnotationPresent(MyAnno.class));

        // 获取属性上定义的注解
        MyAnno anno = f1.getAnnotation(MyAnno.class);
        // 获取注解上的属性值
        System.out.println(anno.name());

    }
}
