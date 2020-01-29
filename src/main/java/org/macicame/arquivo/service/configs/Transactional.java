package org.macicame.arquivo.service.configs;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by acacio on 15/03/19.
 */

@Inherited
@InterceptorBinding
@Retention(RUNTIME)
@Target({METHOD, TYPE})
//TODO: add transaction attributes such as rollbackWhen, isolation levels
//TODO: support for class annotation
public @interface Transactional {

}