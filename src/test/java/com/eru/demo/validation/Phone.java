package com.eru.demo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 自定义手机号注解
 * Created by eru on 2019/12/15.
 */
@Documented
// 作用范围
@Target(ElementType.FIELD)
// 不同之处, 约束注解的验证器
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

    // 约束注解验证时的输出信息
    String message() default "手机号验证错误" ;

    // 约束注解在验证时所属的组别
    Class<?>[] groups() default {};

    // 约束注解的有效负载
    Class<? extends Payload>[] payload() default {};
}
