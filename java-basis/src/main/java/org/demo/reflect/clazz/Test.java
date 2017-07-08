package org.demo.reflect.clazz;

import org.demo.reflect.anno.MyAnno;
import org.demo.reflect.bean.People;

/**
 * Created by Godql on 2017/7/8.
 * 动态操作类相关
 */
public class Test {

    public static void main(String[] args) {
        Class<?> clazz = People.class;
        // 获取类所在的包
        Package p = clazz.getPackage();
        // 获取包名
        System.out.println(p.getName());
        // 获取简单的类名
        System.out.println(clazz.getSimpleName());
        // 获取完整类名
        System.out.println(clazz.getName());
        // 获取当前类的父类
        Class<?> superClass = clazz.getSuperclass();
        // 获取父类的名称
        System.out.println(superClass.getSimpleName());
        // 获取当前类实现的所有接口
        Class<?>[] infs = clazz.getInterfaces();
        for (Class<?> inf : infs) {
            System.out.println(inf.getSimpleName());
        }
        // 判断当前类是否是一个接口
        System.out.println(clazz.isInterface());
        // 判断类上是否定义了注解
        clazz.isAnnotationPresent(MyAnno.class);
    }
}
