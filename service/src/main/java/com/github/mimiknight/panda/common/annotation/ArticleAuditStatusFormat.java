package com.github.mimiknight.panda.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 年级 格式化注解
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-10-25 21:04:11
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
public @interface ArticleAuditStatusFormat {
}
