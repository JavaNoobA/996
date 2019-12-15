package com.eru.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eru on 2019/12/15.
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // 手机号验证规则, 158后头随便
        String check = "158\\d{8}";
        Pattern pattern = Pattern.compile(check);

        // 变值处理
        String phone = Optional.ofNullable(value).orElse("");
        Matcher matcher = pattern.matcher(phone);

        return matcher.matches();
    }
}
