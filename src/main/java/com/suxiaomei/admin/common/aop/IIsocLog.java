package com.suxiaomei.admin.common.aop;

import java.lang.annotation.*;
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented 
public @interface IIsocLog {
    String module()  default "";  
    String methods()  default ""; 
}