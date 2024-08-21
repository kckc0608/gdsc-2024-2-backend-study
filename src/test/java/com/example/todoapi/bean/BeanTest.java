package com.example.todoapi.bean;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    void checkAllBeans() {
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

    @Test
    void checkMyBean() {
        MyBean myBean1 = context.getBean(MyBean.class);
        MyBean myBean2 = context.getBean(MyBean.class);
        System.out.println(myBean1.getClass().getName());
        System.out.println(myBean1);
        System.out.println(myBean2);

        Assertions.assertThat(myBean1).isSameAs(myBean2);
    }

    @Test
    void checkMySubBean() {
        MySubBean mySubBean1 = context.getBean(MySubBean.class);
        MySubBean mySubBean2 = context.getBean(MySubBean.class);
        System.out.println(mySubBean1.getClass().getName());
        System.out.println(mySubBean1);
        System.out.println(mySubBean2);

        Assertions.assertThat(mySubBean1).isSameAs(mySubBean2);
    }

    @Test
    void checkMyBeanHasMySubBean() {
        MyBean myBean = context.getBean(MyBean.class);
        MySubBean mySubBean = context.getBean(MySubBean.class);

        System.out.println("myBean = " + myBean.getMySubBean());
        System.out.println("mySubBean = " + mySubBean);

        Assertions.assertThat(myBean.getMySubBean()).isSameAs(mySubBean);
    }
}
