package cn.com.eshop.base.entity;

    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableField;
    import java.io.Serializable;

/**
* <p>
    * 用户收藏
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class BaseAccountCollection implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId("ID")
    private String id;

            /**
            * 标题
            */
    private String title;

            /**
            * 链接网址
            */
    private String url;

            /**
            * 用户ID
            */
        @TableField("accountId")
    private String accountId;

            /**
            * 用户名称
            */
        @TableField("accountName")
    private String accountName;

            /**
            * 创建时间
            */
        @TableField("createTime")
    private Date createTime;

            /**
            * 创建人
            */
        @TableField("createPerson")
    private String createPerson;

            /**
            * 创建人ID
            */
        @TableField("createPersonIds")
    private String createPersonIds;

            /**
            * 修改时间
            */
        @TableField("modifyTime")
    private Date modifyTime;

            /**
            * 修改人
            */
        @TableField("modifyPerson")
    private String modifyPerson;

            /**
            * 修改人ID
            */
        @TableField("modifyPersonIds")
    private String modifyPersonIds;

            /**
            * 流程状态
            */
    private String status;

            /**
            * 是否删除:N否,Y是
            */
        @TableField("isDelete")
    private String isDelete;

            /**
            * 是否有效:N否,Y是
            */
        @TableField("isDisable")
    private String isDisable;

            /**
            * 模块标识
            */
    private String module;

            /**
            * 模块标识
            */
        @TableField("moduleId")
    private String moduleId;

            /**
            * 备注
            */
    private String remark;

        public String getId() {
        return id;
        }

            public void setId(String id) {
        this.id = id;
        }
        public String getTitle() {
        return title;
        }

            public void setTitle(String title) {
        this.title = title;
        }
        public String getUrl() {
        return url;
        }

            public void setUrl(String url) {
        this.url = url;
        }
        public String getAccountId() {
        return accountId;
        }

            public void setAccountId(String accountId) {
        this.accountId = accountId;
        }
        public String getAccountName() {
        return accountName;
        }

            public void setAccountName(String accountName) {
        this.accountName = accountName;
        }
        public Date getCreateTime() {
        return createTime;
        }

            public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        }
        public String getCreatePerson() {
        return createPerson;
        }

            public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
        }
        public String getCreatePersonIds() {
        return createPersonIds;
        }

            public void setCreatePersonIds(String createPersonIds) {
        this.createPersonIds = createPersonIds;
        }
        public Date getModifyTime() {
        return modifyTime;
        }

            public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
        }
        public String getModifyPerson() {
        return modifyPerson;
        }

            public void setModifyPerson(String modifyPerson) {
        this.modifyPerson = modifyPerson;
        }
        public String getModifyPersonIds() {
        return modifyPersonIds;
        }

            public void setModifyPersonIds(String modifyPersonIds) {
        this.modifyPersonIds = modifyPersonIds;
        }
        public String getStatus() {
        return status;
        }

            public void setStatus(String status) {
        this.status = status;
        }
        public String getIsDelete() {
        return isDelete;
        }

            public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
        }
        public String getIsDisable() {
        return isDisable;
        }

            public void setIsDisable(String isDisable) {
        this.isDisable = isDisable;
        }
        public String getModule() {
        return module;
        }

            public void setModule(String module) {
        this.module = module;
        }
        public String getModuleId() {
        return moduleId;
        }

            public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
        }
        public String getRemark() {
        return remark;
        }

            public void setRemark(String remark) {
        this.remark = remark;
        }

    @Override
    public String toString() {
    return "BaseAccountCollection{" +
            "id=" + id +
            ", title=" + title +
            ", url=" + url +
            ", accountId=" + accountId +
            ", accountName=" + accountName +
            ", createTime=" + createTime +
            ", createPerson=" + createPerson +
            ", createPersonIds=" + createPersonIds +
            ", modifyTime=" + modifyTime +
            ", modifyPerson=" + modifyPerson +
            ", modifyPersonIds=" + modifyPersonIds +
            ", status=" + status +
            ", isDelete=" + isDelete +
            ", isDisable=" + isDisable +
            ", module=" + module +
            ", moduleId=" + moduleId +
            ", remark=" + remark +
    "}";
    }
}
