package cn.com.eshop.common.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: nj
 * @date: 2019/5/9:下午1:59
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceInfoBean {
    private String name;


}
