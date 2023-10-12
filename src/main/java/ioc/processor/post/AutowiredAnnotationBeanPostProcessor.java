package ioc.processor.post;

import ioc.annotation.Autowired;
import ioc.factory.BeanFactory;
import ioc.processor.Processor;

import java.lang.reflect.Field;

/**
 * @author DyingZhang
 * @date 2023-10-11 下午 10:33
 * @discription
 */
public class AutowiredAnnotationBeanPostProcessor implements Processor {

    private BeanFactory beanFactory;

    public AutowiredAnnotationBeanPostProcessor() {
    }

    public AutowiredAnnotationBeanPostProcessor(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public <T> void doProcessor(T t) {
        Class<?> clazz = t.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Autowired.class)) {
                Class<?> type = field.getType();
                Object o = beanFactory.getBean(type);
                try {
                    field.set(t, o);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
