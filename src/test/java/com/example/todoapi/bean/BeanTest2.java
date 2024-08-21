package com.example.todoapi.bean;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest2 {

    @Autowired
    private MyBean myBean;

    @Autowired
    private MySubBean mySubBean;

    @Test
    void checkMyBeanHasMySubBean() {
        System.out.println("myBean = " + myBean.getMySubBean());
        System.out.println("mySubBean = " + mySubBean);

        Assertions.assertThat(myBean.getMySubBean()).isSameAs(mySubBean);
    }
}
