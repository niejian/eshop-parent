package cn.com.eshop.admin.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * @author: nj
 * @date: 2019/5/24:下午4:44
 */
@Data
@Slf4j
public class MenuNodeVo implements Serializable {
    private String name;
    private Boolean spread;
    private Long menuId;
    private String url;
    private String menuCode;
    private Integer num;
    private boolean leaf;
    private String icon;
    private List<MenuNodeVo> children;
}
