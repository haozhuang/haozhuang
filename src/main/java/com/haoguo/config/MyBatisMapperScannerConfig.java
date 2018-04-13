package com.haoguo.config;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2018-04-13
 * Time: AM 11:29
 */

/**
 *
 * @author zhuang.hao
 * @create 2018-04-13 AM 11:29
 **/
@Configuration
//必须在MyBatisConfig注册后再加载MapperScannerConfigurer，否则会报错
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryHao");
        mapperScannerConfigurer.setBasePackage("com.haoguo.mapper");
        return mapperScannerConfigurer;
    }
}
