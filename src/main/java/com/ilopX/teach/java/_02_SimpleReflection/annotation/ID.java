package com.ilopX.teach.java._02_SimpleReflection.annotation;

import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ID {
}
