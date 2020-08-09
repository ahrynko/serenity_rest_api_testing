package com.github.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  //запуск во время компиляции
@Target(ElementType.FIELD)   // на поле
public @interface ColumnName {

    String name();
}
