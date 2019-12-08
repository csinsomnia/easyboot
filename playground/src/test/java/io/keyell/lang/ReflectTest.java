package io.keyell.lang;

import org.junit.Test;

/**
 * 1.测试class.newInstance()会调用Class的无参构造函数初始化
 * 2.测试 JVM 会默认提供无参构造函数 （当类中无任何构造函数时）
 *
 * @author huangke 创建于 2019-12-08
 */
public class ReflectTest {

//    public ReflectTest(int arg) {
//        System.out.println("存在参数构造函数");
//    }

    @Test
    public void testNewInstance() {
        try {
            // ReflectTest没有无参数构造函数,也没有带参构造函数。JVM会默认创建一个无参构造函数
            // 反射创建 ReflectTest 实例成功
            ReflectTest t = ReflectTest.class.newInstance();
            System.out.println(t);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testNewInstanceWithConstructor() {
        try {
            // 运行此测试，需要打开 ReflectTest带参数构造函数 注释，但是仍然没有无参构造函数
            // 反射创建 ReflectTest 实例失败，JVM不会默认创建一个无参构造函数
            // java.lang.Exception: Test class should have exactly one public zero-argument constructor
            ReflectTest t = ReflectTest.class.newInstance();
            System.out.println(t);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
