package com.ilopX.teach.java._02_SimpleReflection;

import java.lang.annotation.*;

@Inherited
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Name {
    int minNameLength() default 3;
    int maxNameLength() default 8;
}
