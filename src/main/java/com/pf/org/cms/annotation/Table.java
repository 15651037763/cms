package com.pf.org.cms.annotation;

import java.lang.annotation.*;

/**
 * @Auther: pf
 * @Date: 2018/2/7 19:42
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    String value();
}
