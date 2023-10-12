package bean;

import ioc.annotation.Autowired;
import ioc.annotation.Component;

/**
 * @author DyingZhang
 * @date 2023-10-12 下午 5:06
 * @discription
 */
@Component
public class Bean1 {

    @Autowired
    public Bean2 bean2;

    public Bean2 getBean2() {
        return bean2;
    }

    public void setBean2(Bean2 bean2) {
        this.bean2 = bean2;
    }
}
