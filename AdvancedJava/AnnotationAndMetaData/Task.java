package Java_Bootcamp.AdvancedJava.AnnotationAndMetaData;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Annotation for marking methods with priority and description
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Task {
    String description();

    int priority() default 1;
}
