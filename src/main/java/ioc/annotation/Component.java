package ioc.annotation;

import java.lang.annotation.*;

/**
 * @author DyingZhang
 * @date 2023-10-12 下午 5:31
 * @discription
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
}
