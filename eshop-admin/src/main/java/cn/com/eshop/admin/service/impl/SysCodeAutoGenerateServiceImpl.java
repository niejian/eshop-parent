package cn.com.eshop.admin.service.impl;/**
 * Created by niejian on 2019/7/2.
 */

import cn.com.eshop.admin.service.SysCodeAutoGenerateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niejian
 * @date 2019/7/2
 */
@Slf4j
@Service
public class SysCodeAutoGenerateServiceImpl implements SysCodeAutoGenerateService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String GET_TABLES = "show tables;";

    /**
     * 获取所有表名
     *
     * @return
     */
    @Override
    public List<String> getTables() {
        return this.jdbcTemplate.queryForList(GET_TABLES, String.class);
    }

}
