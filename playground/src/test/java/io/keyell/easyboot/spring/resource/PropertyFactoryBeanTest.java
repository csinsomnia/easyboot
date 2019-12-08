package io.keyell.easyboot.spring.resource;

import org.junit.Test;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * @author huangke 创建于 2019-12-06
 */
public class PropertyFactoryBeanTest {


    @Test
    public void testPropertyFactoryBean() throws IOException {
//        Resource[] locations = {};

//        PropertiesFactoryBean b = new PropertiesFactoryBean();

        // Properties properties = PropertiesLoaderUtils.loadAllProperties("classpath:a.properties");
        Properties properties = PropertiesLoaderUtils.loadAllProperties("a.properties");

        properties.entrySet().forEach(entry -> {
            System.out.println(MessageFormat.format("[key: {0}, value: {1}]", entry.getKey(), entry.getValue()));
        });


        // classpath:b.properties
        Resource resource = new ClassPathResource("b.properties");

        properties = PropertiesLoaderUtils.loadProperties(resource);

        properties.entrySet().forEach(entry -> System.out.println(MessageFormat.format("[key: {0}, value: {1}]", entry.getKey(), entry.getValue())));

//        Resource[] r = new Resource[] {
//                "classpath:a.properties",
//                "classpath:a.properties",
//        };
//
//        URL

    }
}
