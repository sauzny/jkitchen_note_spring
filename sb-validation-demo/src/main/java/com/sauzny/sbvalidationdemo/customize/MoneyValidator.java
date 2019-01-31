package com.sauzny.sbvalidationdemo.customize;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/***************************************************************************
 *
 * @时间: 2019/1/31 - 13:32
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class MoneyValidator implements ConstraintValidator<Money, Double> {

    private String moneyReg = "^\\d+(\\.\\d{1,2})?$";//表示金额的正则表达式
    private Pattern moneyPattern = Pattern.compile(moneyReg);

    public void initialize(Money money) {
        // TODO Auto-generated method stub

    }

    public boolean isValid(Double value, ConstraintValidatorContext arg1) {
        if (value == null)
            //金额是空的，返回true，是因为如果null，则会有@NotNull进行提示
            //如果这里false的话，那金额是null，@Money中的message也会进行提示
            //自己可以尝试
            return true;
        return moneyPattern.matcher(value.toString()).matches();
    }

}