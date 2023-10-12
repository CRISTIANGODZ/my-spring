package ioc.factory;

import ioc.annotation.Component;
import ioc.exception.BeanInjectException;
import ioc.exception.CaptureBeanException;
import ioc.processor.Processor;
import ioc.processor.post.AutowiredAnnotationBeanPostProcessor;
import ioc.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author DyingZhang
 * @date 2023-10-11 下午 10:25
 * @discription
 */
public class DefaultBeanFactory implements BeanFactory{

    private Map<String, Object> map = new HashMap<>();

    private List<Processor> processorList = new ArrayList<>();

    @Override
    public <T> T getBean(String name, Class<T> clazz) {
        if (map.containsKey(name)) {
            Object o = map.get(name);
            try {
                T t = (T) o;
                return t;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        List<Map.Entry<String, Object>> list = map.entrySet().stream().filter(entry ->
                clazz.getTypeName().equals(entry.getValue().getClass().getTypeName()))
                .collect(Collectors.toList());
        try {
            if (list.size() == 1) {
                return (T)list.get(0).getValue();
            } else if (list.size() == 0) {
                return null;
            } else {
                throw new CaptureBeanException("DUPLICATED INSTANCE EXISTS OF CLASS \"" + clazz.getTypeName() + "\"");
            }
        } catch (CaptureBeanException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object getBean(String name) {
        return map.containsKey(name) ? map.get(name) : null;
    }

    public void addProcessor(Class clazz) {
        if (clazz.getTypeName().equals(AutowiredAnnotationBeanPostProcessor.class.getTypeName())) {
            AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor(this);
            processorList.add(autowiredAnnotationBeanPostProcessor);
        }
    }

    @Override
    public <T> T registerBean(Class<T> clazz) {
        try {
            if (clazz.isAnnotationPresent(Component.class)) {
                T t = clazz.newInstance();
                String name = clazz.getName();
                map.put(StringUtils.toCamelPattern(name.substring(name.lastIndexOf(".") + 1)), t);
                processorList.forEach(processor -> {
                    processor.doProcessor(t);
                });
                return t;
            } else {
                throw new BeanInjectException("COMPONENT");
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (BeanInjectException e) {
            throw new RuntimeException(e);
        }
    }


}
