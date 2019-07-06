package cn.com.eshop.common.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 数据表描述
 * @author: nj
 * @date: 2019-07-05:17:11
 */
@ToString
@Data
public class TableDescDto implements Serializable {
    private String tableName;
    /**数据表 字段-类型映射列表*/
    private List<Map<String, String>> fieldNameTypeMapList;


}
