package com.xsy.notebook.notebookspringboot;

import com.xsy.notebook.notebookspringboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @author xushuyuan@zj.tech
 * @date 2021/9/4 22:55
 */
public class XmlFactoryTest {

    @Test
    public void getBeanTest() throws IOException {
        Resource resource = new ClassPathResource("spring-config.xml");
        System.out.println(resource.getURI());
        System.out.println(resource.getURL());
        System.out.println(resource.getDescription());
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        beanFactory.getBean(User.class);
    }

}
