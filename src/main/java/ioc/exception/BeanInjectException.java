package ioc.exception;

/**
 * @author DyingZhang
 * @date 2023-10-12 下午 5:39
 * @discription
 */
public class BeanInjectException extends Exception {
    static final long serialVersionUID = -3387516993124229948L;

    public BeanInjectException() {
    }

    public BeanInjectException(String message) {
        super("Spring Exception: BEAN INJECT WRONG, WITHOUT " + message + " ANNOTATION");
    }
}
