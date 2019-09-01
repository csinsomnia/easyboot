package io.keyell.spring.ioc.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author huangke 创建于 2019-05-11
 */
public class InitApplicationContext {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx1  = new ClassPathXmlApplicationContext(
//                "classpath:./init-context.xml"
//                "classpath:init-context.xml"
                "classpath:/io/keyell/spring/ioc/bean/init-context.xml"
//                "classpath:/**/*.xml"
        );

        FileSystemXmlApplicationContext ctx2 = new FileSystemXmlApplicationContext(
                "classpath:/io/keyell/spring/ioc/bean/init-context.xml"
        );

        System.out.println(ctx1.getBean("b1"));
        System.out.println(ctx2.getBean("b2"));
    }
}
