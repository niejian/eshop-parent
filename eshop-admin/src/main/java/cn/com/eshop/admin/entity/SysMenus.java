package cn.com.eshop.admin.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 菜单信息表
    * </p>
*
* @author code4fun
* @since 2019-05-23
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class SysMenus implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String menuCode;

    private String menuName;

            /**
            * 菜单类型（0：菜单；1：按钮）
            */
    private Boolean menuType;

            /**
            * 是否叶子节点（1：叶子节点，1：非叶子节点）
            */
    private Boolean leaf;

            /**
            * 父菜单id集合
            */
    private String parentIds;

            /**
            * 父菜单id集合
            */
    private Long parentId;

    private String menuUrl;

            /**
            * 排序
            */
    private Integer num;

    private String icon;

    private Date createTime;

    private String createBy;

    private Date modifyTime;

    private String modifyBy;


}
