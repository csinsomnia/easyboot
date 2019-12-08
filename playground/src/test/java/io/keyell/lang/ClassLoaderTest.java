package io.keyell.lang;

import org.junit.Test;

/**
 * @author huangke 创建于 2019-12-07
 */
public class ClassLoaderTest {

    @Test
    public void testClassLoaderOrder() {
        // 获得加载ClassLoaderTest.class这个类的类加载器
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();


//        sun.misc.Launcher$AppClassLoader@18b4aac2
//        sun.misc.Launcher$ExtClassLoader@198e2867
//        null
        while (loader != null) {

            System.out.println(loader);

            loader = loader.getParent();    // 获得父类加载器的引用

        }

        System.out.println(loader);


//        sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(ClassLoader.getSystemClassLoader());

    }
}
