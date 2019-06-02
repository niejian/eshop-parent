package cn.com.eshop.admin.utils;/**
 * Created by niejian on 2019/6/1.
 */

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * Xtree vo。生成带复选框的树形菜单信息
 *          title: "节点1", value: "jd1", data: []
 * @author niejian
 * @date 2019/6/1
 */

@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class XtreeNodeVo implements Serializable {
    private String title;
    private String value;
    private List<XtreeNodeVo> data;
    /**单选框是否选中*/
    private Boolean checked = false;


}
