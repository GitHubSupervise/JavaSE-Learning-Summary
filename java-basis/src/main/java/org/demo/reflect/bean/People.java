package org.demo.reflect.bean;

import org.demo.reflect.anno.MyAnno;

/**
 * Created by Godql on 2017/7/8.
 */
public class People extends P implements PeopleInf, WorkInf {

    @MyAnno(name = "hello")
    public String userName = "Godql";

    private int age = 21;

    public People() {
        System.out.println("hello People");
    }

    private People(String name) {
        System.out.println("hello" + name);
    }

    public void say(String name, int age) {
        System.out.println("hello" + name + ", age is" + age);
    }

    private void run() {
        System.out.println("running...");
    }
}
