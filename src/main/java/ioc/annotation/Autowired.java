package ioc.annotation;

import java.lang.annotation.*;

/**
 * @author DyingZhang
 * @date 2023-10-11 下午 10:20
 * @discription
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {
    boolean isRequired() default true;
}
