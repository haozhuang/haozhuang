package com.haoguo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2018-04-13
 * Time: AM 11:33
 */
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author zhuang.hao
 * @create 2018-04-13 AM 11:33
 **/
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
