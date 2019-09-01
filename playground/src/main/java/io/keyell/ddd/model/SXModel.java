package io.keyell.ddd.model;

/**
 * 失血模型：模型仅仅包含数据的定义和getter/setter方法，业务逻辑和应用逻辑都放到服务层中。
 * 这种类在java中叫POJO，在.NET中叫POCO
 *
 * 以用户对象 User 为例
 *
 * @author huangke 创建于 2019-09-01
 */
public class SXModel {
    private String userId;
    private String userName;
    private String phone;
    private Integer age;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
