package ioc.factory;

/**
 * @author DyingZhang
 * @date 2023-10-11 下午 10:22
 * @discription
 */
public interface BeanFactory {
    Object getBean(String name);
    <T> T getBean(String name, Class<T> clazz);
    <T> T getBean(Class<T> clazz);

    <T> T registerBean(Class<T> clazz);
}
