package com.pf.org.cms.annotation;

import java.lang.annotation.*;

/**
 * @Auther: pf
 * @Date: 2018/2/7 19:38
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Id {
    String value();
}
