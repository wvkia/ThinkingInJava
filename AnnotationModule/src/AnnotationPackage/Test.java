package AnnotationPackage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //注解作用的地方
@Retention(RetentionPolicy.RUNTIME) //该注解在哪个级别可用
public @interface Test {
    //没有元素的注解称为标记注解
}
