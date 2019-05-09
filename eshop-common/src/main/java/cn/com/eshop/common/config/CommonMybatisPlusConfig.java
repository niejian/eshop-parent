package cn.com.eshop.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.apache.ibatis.plugin.Interceptor;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: nj
 * @date: 2019/5/9:下午2:05
 */
@Configuration
@MapperScan(basePackages = {"cn.com.eshop.*.mapper"})
public class CommonMybatisPlusConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public MybatisSqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        mybatisSqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:/cn/com/eshop/*/mapper/*Mapper.xml"));

        List<Interceptor> interceptors = new ArrayList<>();
        Interceptor[] interceptorsArr = new Interceptor[1];
        interceptorsArr[0] = paginationInterceptor();
        interceptors.add(paginationInterceptor());
        mybatisSqlSessionFactoryBean.setPlugins(interceptorsArr);

        return mybatisSqlSessionFactoryBean;
    }



    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }


    /**
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}

