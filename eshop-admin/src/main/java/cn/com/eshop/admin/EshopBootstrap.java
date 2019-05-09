package cn.com.eshop.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author niejian
 * @date 2019/5/6
 */
@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = {"cn.com.eshop.common", "cn.com.eshop.admin"})
@MapperScan(basePackages = {"cn.com.eshop.admin.mapper"})
public class EshopBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(EshopBootstrap.class, args);
    }
}
