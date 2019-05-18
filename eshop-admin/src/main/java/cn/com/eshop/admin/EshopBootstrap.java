package cn.com.eshop.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author niejian
 * @date 2019/5/6
 */
@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = {"cn.com.eshop.common", "cn.com.eshop.admin"})
@MapperScan(basePackages = {"cn.com.eshop.admin.mapper"})
public class EshopBootstrap extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EshopBootstrap.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(EshopBootstrap.class, args);
    }
}
