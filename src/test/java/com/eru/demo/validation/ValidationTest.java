package com.eru.demo.validation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
 * 验证测试类
 * Created by eru on 2019/12/15.
 */
public class ValidationTest {

    /**
     * 验证器对象
     */
    private Validator validator;

    /**
     * 待验证对象
     */
    private UserInfo userInfo;

    /**
     * 验证结果集
     */
    private Set<ConstraintViolation<UserInfo>> set;

    /**
     * 验证结果集
     */
    private Set<ConstraintViolation<UserInfoService>> otherSet;

    @Before
    public void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        userInfo = new UserInfo();
        //userInfo.setUserId("erudev");
        userInfo.setUserName("  ");
        userInfo.setPassword(" 22222 ");
        userInfo.setEmail("erudev@gmail.com");
        userInfo.setAge(18);
        userInfo.setPhone("13800000000");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1996, 2, 24);
        userInfo.setBirthday(calendar.getTime());

        UserInfo friend = new UserInfo();
        friend.setUserId("111");
        friend.setPassword("2222222");
        friend.setUserName("zhangsan");
        userInfo.setFriends(new ArrayList(){{
            add(friend);
        }});
    }

    @Test
    public void notnullTest(){
        set = validator.validate(userInfo);
    }

    /**
     * 级联验证测试方法
     */
    @Test
    public void graphValidation(){
        set = validator.validate(userInfo);
    }

    /**
     * 分组验证测试方法
     */
    @Test
    public void groupValidation(){
        set = validator.validate(userInfo, UserInfo.LoginGroup.class, UserInfo.RegisterGroup.class);
    }

    /**
     * 组序列验证测试方法
     */
    @Test
    public void groupSequenceValidation(){
        set = validator.validate(userInfo, UserInfo.Group.class);
    }

    /**
     * 对方法输入参数进行约束检验
     */
    @Test
    public void paramValidation() throws NoSuchMethodException {
        // 获取检验执行器
        ExecutableValidator executableValidator = validator.forExecutables();

        UserInfoService service = new UserInfoService();

        // 待验证方法
        Method method = service.getClass().getMethod("setUserInfo", UserInfo.class);

        // 方法输入参数
        Object[] params = new Object[]{new UserInfo()};

        otherSet = executableValidator.validateParameters(service, method, params);
    }

    /**
     * 对返回值进行约束检验
     */
    @Test
    public void returnValueValidation() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ExecutableValidator executableValidator = validator.forExecutables();

        UserInfoService service = new UserInfoService();

        Method method = service.getClass().getMethod("getUserInfo");

        Object object = method.invoke(service);

        // 对方法返回值进行检验
        otherSet = executableValidator.validateReturnValue(service, method, object);
    }

    @After
    public void print(){
        set.forEach(item -> {
            System.out.println(item.getMessage());
        });
        //otherSet.forEach(item -> {
        //    System.out.println(item.getMessage());
        //});
    }
}
