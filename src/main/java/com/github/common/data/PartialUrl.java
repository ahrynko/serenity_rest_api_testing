package com.github.common.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  //куда вешать аннотацию
@Retention(RetentionPolicy.RUNTIME) //SOURCE - исходные коды, не компилируемая (target) | CLASS- none RUNTIME
public @interface PartialUrl {

    String value(); //method (поле обязательное) "set stroka"   // init пустая строка -default = "";
}
