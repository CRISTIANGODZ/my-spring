package ioc.exception;

/**
 * @author DyingZhang
 * @date 2023-10-12 下午 5:52
 * @discription
 */
public class CaptureBeanException extends Exception {
    static final long serialVersionUID = -3387516993124229948L;

    public CaptureBeanException() {
    }

    public CaptureBeanException(String message) {
        super("Spring Exception: BEAN CAPTURE WRONG, " + message);
    }
}
