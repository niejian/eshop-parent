package cn.com.eshop.admin.config.kaptcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 验证码相关配置
 * @author niejian
 * @date 2019/7/7
 */
@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();
        properties.put("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "105,179,90");

//        properties.put("kaptcha.textproducer.font.color", "black");
        properties.put("kaptcha.textproducer.char.space", "10");
        properties.put("kaptcha.textproducer.char.length","5");
        properties.put("kaptcha.image.height","46");
        properties.put("kaptcha.image.width","180");
        properties.put("kaptcha.textproducer.font.size","25");
        properties.setProperty("kaptcha.noise.color", "black");
        properties.setProperty("kaptcha.background.clear.from", "102,153,153");
        properties.setProperty("kaptcha.background.clear.to", "183,234,112");

        //kaptcha.obscurificator.impl生成验证码，我理解的就是样式，有三种，水纹，鱼眼，阴影com.google.code.kaptcha.impl.ShadowGimpy，我用的就是这个阴影，感觉这个显示效果最好
        properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

}
