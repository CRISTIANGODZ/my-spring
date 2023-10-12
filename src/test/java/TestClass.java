import bean.Bean1;
import bean.Bean3;
import ioc.annotation.Autowired;
import ioc.processor.post.AutowiredAnnotationBeanPostProcessor;
import ioc.util.StringUtils;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author DyingZhang
 * @date 2023-10-12 下午 5:12
 * @discription
 */
public class TestClass {
    @Test
    public void test1() {
        String name = "bean.Bean1";
    }

    @Test
    public void test2() {
        System.out.println(StringUtils.toCamelPattern("Bean1"));
    }

    @Test
    public void test3() {
        Bean1 bean1 = new Bean1();
        for (Field field : bean1.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Autowired.class)) {
                Class<?> declaringClass = field.getDeclaringClass();
                System.out.println(declaringClass);
            }
        }
    }
}
