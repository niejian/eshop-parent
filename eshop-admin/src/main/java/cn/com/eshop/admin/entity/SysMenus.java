package cn.com.eshop.admin.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 菜单信息表
    * </p>
*
* @author code4fun
* @since 2019-05-19
*/
    public class SysMenus implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String menuCode;

    private String menuName;

            /**
            * 父菜单id集合
            */
    private String parentIds;

            /**
            * 父菜单id集合
            */
    private Long parentId;

    private String menuUrl;

    private Date createTime;

    private String createBy;

    private Date modifyTime;

    private String modifyBy;

        public Long getId() {
        return id;
        }

            public void setId(Long id) {
        this.id = id;
        }
        public String getMenuCode() {
        return menuCode;
        }

            public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
        }
        public String getMenuName() {
        return menuName;
        }

            public void setMenuName(String menuName) {
        this.menuName = menuName;
        }
        public String getParentIds() {
        return parentIds;
        }

            public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
        }
        public Long getParentId() {
        return parentId;
        }

            public void setParentId(Long parentId) {
        this.parentId = parentId;
        }
        public String getMenuUrl() {
        return menuUrl;
        }

            public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
        }
        public Date getCreateTime() {
        return createTime;
        }

            public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        }
        public String getCreateBy() {
        return createBy;
        }

            public void setCreateBy(String createBy) {
        this.createBy = createBy;
        }
        public Date getModifyTime() {
        return modifyTime;
        }

            public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
        }
        public String getModifyBy() {
        return modifyBy;
        }

            public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
        }

    @Override
    public String toString() {
    return "SysMenus{" +
            "id=" + id +
            ", menuCode=" + menuCode +
            ", menuName=" + menuName +
            ", parentIds=" + parentIds +
            ", parentId=" + parentId +
            ", menuUrl=" + menuUrl +
            ", createTime=" + createTime +
            ", createBy=" + createBy +
            ", modifyTime=" + modifyTime +
            ", modifyBy=" + modifyBy +
    "}";
    }
}
