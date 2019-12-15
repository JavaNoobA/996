package com.eru.demo.validation;

import org.hibernate.validator.constraints.Length;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.util.Date;
import java.util.List;

/**
 * 用户信息类
 * Created by eru on 2019/12/15.
 */
public class UserInfo {

    // 登录场景
    public interface LoginGroup {}

    // 注册场景
    public interface RegisterGroup {}

    /**
     * 组序列, 按照给定的group顺序进行校验
     */
    @GroupSequence({
            LoginGroup.class,
            RegisterGroup.class,
            Default.class
    })
    public interface Group{}

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空",
            groups = LoginGroup.class
    )
    private String userId;

    /**
     * NotEmpty: 不会去除两边的空字符进行校验
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    /**
     * NotBlank: 会去除两边的空字符进行校验
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 20, message = "不能少于6位, 不能大于20位")
    private String password;

    /**
     * 邮箱
     */
    @NotNull(message = "邮箱不能为空",
            groups = RegisterGroup.class
    )
    @Email(message = "邮箱必须为有效邮箱")
    private String email;

    /**
     * 手机号
     */
    @Phone(message = "手机号不是158后头随便")
    private String phone;

    /**
     * 年龄
     */
    @Min(value = 18, message = "年龄不能小于18岁")
    @Max(value = 60, message = "年龄不能大于60岁")
    private Integer age;

    /**
     * 生日
     */
    @Past(message = "生日不能是未来的时间点或者当前时间点")
    private Date birthday;

    /**
     * 好友列表
     */
    @Size(min = 1, message = "好友列表不能少于1")
    private List<@Valid UserInfo> friends;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<UserInfo> getFriends() {
        return friends;
    }

    public void setFriends(List<UserInfo> friends) {
        this.friends = friends;
    }
}
