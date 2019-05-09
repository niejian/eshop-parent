package cn.com.eshop.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: nj
 * @date: 2019/5/9:下午2:22
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "cn.com.eshop.common",
        "cn.com.eshop.product"
})
public class EshopProductBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(EshopProductBootstrap.class, args);
    }
}
