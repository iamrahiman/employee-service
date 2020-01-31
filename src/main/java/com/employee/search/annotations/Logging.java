package com.employee.search.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * annotation to apply logger
 * @author abdul.rahimanshaik
 *
 */
@Target(ElementType.METHOD)//applied on method level
@Retention(RetentionPolicy.RUNTIME)//apply on runtime
public @interface Logging {
	

}
