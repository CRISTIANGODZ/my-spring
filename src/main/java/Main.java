import bean.Bean1;
import bean.Bean2;
import ioc.factory.DefaultBeanFactory;
import ioc.processor.post.AutowiredAnnotationBeanPostProcessor;

/**
 * @author DyingZhang
 * @date 2023-10-12 下午 5:06
 * @discription
 */
public class Main {
    public static void main(String[] args) {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();
        beanFactory.addProcessor(AutowiredAnnotationBeanPostProcessor.class);
        Bean2 bean2 = beanFactory.registerBean(Bean2.class);
        System.out.println(bean2);
        Bean1 bean1 = beanFactory.registerBean(Bean1.class);
        System.out.println(bean1.getBean2());



    }
}
