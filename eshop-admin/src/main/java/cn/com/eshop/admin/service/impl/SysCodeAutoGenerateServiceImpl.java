package cn.com.eshop.admin.service.impl;/**
 * Created by niejian on 2019/7/2.
 */

import cn.com.eshop.admin.service.SysCodeAutoGenerateService;
import cn.com.eshop.common.dto.TableDescDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 通过表明获取表详细信息
     *
     * @param tableName
     * @return
     * @throws Exception
     */
    @Override
    public TableDescDto getTableDetail(String tableName) throws Exception {
        SqlRowSet sqlRowSet = this.jdbcTemplate.queryForRowSet("select * from " + tableName + " limit 1");
        TableDescDto tableDescDto = new TableDescDto();
        List<Map<String, String>> fieldNameTypeMapList = new ArrayList<>();
        // 获取表元数据
        SqlRowSetMetaData metaData = sqlRowSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            Map<String,String> fieldMap = new HashMap<>();
            String columnName = metaData.getColumnName(i);
            String columnType = metaData.getColumnTypeName(i);
            fieldMap.put(columnName, columnType);
            fieldNameTypeMapList.add(fieldMap);
        }
        tableDescDto.setFieldNameTypeMapList(fieldNameTypeMapList);
        tableDescDto.setTableName(metaData.getTableName(1));
        return tableDescDto;
    }
}
