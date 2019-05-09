package cn.com.eshop.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: nj
 * @date: 2019/5/9:上午11:47
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "cn.com.eshop.common",
        "cn.com.eshop.base"
})
public class EshopBaseBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(EshopBaseBootstrap.class, args);
    }
}
