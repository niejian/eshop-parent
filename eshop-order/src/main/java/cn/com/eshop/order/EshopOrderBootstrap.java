package cn.com.eshop.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: nj
 * @date: 2019/5/9:下午2:25
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "cn.com.eshop.order",
        "cn.com.eshop.common"
})
public class EshopOrderBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(EshopOrderBootstrap.class, args);
    }
}
