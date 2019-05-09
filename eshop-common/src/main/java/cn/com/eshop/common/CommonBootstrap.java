package cn.com.eshop.common;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: nj
 * @date: 2019/5/9:上午9:55
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = {
        "cn.com.eshop.common"
})
public class CommonBootstrap {
}
