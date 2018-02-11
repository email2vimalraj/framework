package com.altimetrik.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface NeedBrowser {
    /**
     * A browser name
     * @return The name of the browser to instantiate a driver object
     */
    String name() default "";
}
