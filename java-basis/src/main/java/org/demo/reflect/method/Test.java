package org.demo.reflect.method;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by wangl on 2016/12/8.
 * 动态操作方法
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("org.demo.reflect.bean.People");
        Object instance = clazz.newInstance();
        // 获取指定的Method,如果
        Method m1 = clazz.getMethod("say", String.class, int.class);
        // 获取方法名
        System.out.println(m1.getName());
        // 获取方法的返回值类型
        System.out.println(m1.getReturnType());
        // 获取方法的所有参数类型
        Class<?>[] paramsType = m1.getParameterTypes();
        for (Class<?> c : paramsType) {
            System.out.println(c);
        }
        // 获取参数名称（JDK1.8开始支持）
        Parameter[] params = m1.getParameters();
        for (Parameter p : params) {
            System.out.println("参数类型:"+p.getType());
            System.out.println("参数名称:"+p.getName());
        }
        // 通过当前的方法，获取定义这个方法的类
        Class<?> c = m1.getDeclaringClass();
        System.out.println(c.getName());

        // 方法回调，目的就是通过反射去调用一个方法
        m1.invoke(instance, "Godql", 21);

    }
}
