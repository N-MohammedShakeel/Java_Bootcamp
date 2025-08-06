package Java_Bootcamp.Advanced_Java.Annotation_MetaData;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Repeatable;

// Repeatable annotation (requires a container annotation)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Categories.class)
@interface Category {
    String value();
}