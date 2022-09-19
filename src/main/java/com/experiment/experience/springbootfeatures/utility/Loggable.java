package com.experiment.experience.springbootfeatures.utility;


import org.springframework.boot.logging.LogLevel;
import org.springframework.context.annotation.Scope;

import javax.lang.model.element.TypeElement;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, METHOD})
@Retention(RUNTIME)
@Inherited
public @interface Loggable {

    boolean params() default true;

    boolean result() default true;

    LogLevel value() default LogLevel.DEBUG;

}
