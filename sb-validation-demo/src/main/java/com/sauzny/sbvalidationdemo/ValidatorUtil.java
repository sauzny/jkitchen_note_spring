package com.sauzny.sbvalidationdemo;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/***************************************************************************
 *
 * @时间: 2019/1/30 - 17:32
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class ValidatorUtil {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> Map<String, StringBuffer> validate(T obj) {
        Map<String, StringBuffer> errorMap = null;
        Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
        if (set != null && set.size() > 0) {
            errorMap = new HashMap<String, StringBuffer>();
            String property = null;
            for (ConstraintViolation<T> cv : set) {
                //这里循环获取错误信息，可以自定义格式
                property = cv.getPropertyPath().toString();
                if (errorMap.get(property) != null) {
                    errorMap.get(property).append("," + cv.getMessage());
                } else {
                    StringBuffer sb = new StringBuffer();
                    sb.append(cv.getMessage());
                    errorMap.put(property, sb);
                }
            }
        }
        return errorMap;
    }

    public static void print(Map<String,StringBuffer> errorMap){
        if(errorMap != null){
            for(Map.Entry<String, StringBuffer> m : errorMap.entrySet()){
                System.out.println(m.getKey() + ":" + m.getValue().toString());
            }
        }
    }
}
