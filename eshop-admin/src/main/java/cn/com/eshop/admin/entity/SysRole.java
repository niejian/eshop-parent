package cn.com.eshop.admin.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 角色信息表
    * </p>
*
* @author code4fun
* @since 2019-05-19
*/
    public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String roleCode;

    private String roleName;

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
        public String getRoleCode() {
        return roleCode;
        }

            public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
        }
        public String getRoleName() {
        return roleName;
        }

            public void setRoleName(String roleName) {
        this.roleName = roleName;
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
    return "SysRole{" +
            "id=" + id +
            ", roleCode=" + roleCode +
            ", roleName=" + roleName +
            ", createTime=" + createTime +
            ", createBy=" + createBy +
            ", modifyTime=" + modifyTime +
            ", modifyBy=" + modifyBy +
    "}";
    }
}
