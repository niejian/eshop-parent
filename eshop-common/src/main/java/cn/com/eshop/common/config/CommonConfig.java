package cn.com.eshop.common.config;/**
 * Created by niejian on 2019/5/6.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author niejian
 * @date 2019/5/6
 */
@Configuration
@EnableWebMvc
public class CommonConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置json返回数据
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setDefaultCharset(Charset.forName("UTF-8"));

        converters.add(jsonConverter);
    }
}
