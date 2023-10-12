package ioc.processor;

/**
 * @author DyingZhang
 * @date 2023-10-12 下午 6:05
 * @discription
 */
public interface Processor {

    <T> void doProcessor(T t);

}
