package cn.com.eshop.admin.service;

import cn.com.eshop.common.dto.TableDescDto;

import java.util.List;

/**
 * Created by niejian on 2019/7/2.
 */
public interface SysCodeAutoGenerateService {

    /**
     * 获取所有表名
     * @return
     */
    List<String> getTables();

    /**
     * 通过表明获取表详细信息
     * @param tableName
     * @return
     * @throws Exception
     */
    TableDescDto getTableDetail(String tableName) throws Exception;
}
