package com.sauzny.sbvalidationdemo.customize;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***************************************************************************
 *
 * @时间: 2019/1/31 - 13:30
 *
 * @描述: TODO
 *
 ***************************************************************************/
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=MoneyValidator.class)
public @interface Money {
    String message() default"不是金额形式";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
