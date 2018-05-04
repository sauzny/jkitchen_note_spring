package com.sauzny.sb_mybatis_mds.config.dds;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })

public @interface ChooseDDS {
    String value() default DDS.sbw;
}
