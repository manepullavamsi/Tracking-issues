package com.experiment.experience.springbootfeatures.utility;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.*;
import org.springframework.boot.logging.LogLevel;

@Target({TYPE, METHOD})
@Retention(RUNTIME)
@Inherited
public @interface Loggable {

    boolean params() default true;

    boolean result() default true;

    LogLevel value() default LogLevel.DEBUG;
}
