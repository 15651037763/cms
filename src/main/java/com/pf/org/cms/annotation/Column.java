package com.pf.org.cms.annotation;

import java.lang.annotation.*;

/**
 * @Auther: pf
 * @Date: 2018/2/7 19:36
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {
    String value();
}
