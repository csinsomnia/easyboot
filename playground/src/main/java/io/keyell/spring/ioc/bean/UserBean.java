package io.keyell.spring.ioc.bean;

/**
 * @author huangke 创建于 2019-05-11
 */
public class UserBean {

    /**
     * bean 使用property定义  必须声明无参构造函数
     * 注释掉这个构造函数 看看b1 bean的定义报错
     */
    public UserBean() {
        this.name = null;
        this.age = 0;
    }

    public UserBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    @Override
    public String toString() {
        return "欢迎 " + this.name + " , 你已经 " + this.age + " 岁了!";
    }
}
