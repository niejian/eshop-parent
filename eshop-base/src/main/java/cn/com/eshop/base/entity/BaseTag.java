package cn.com.eshop.base.entity;

    import java.util.Date;
    import java.io.Serializable;

/**
* <p>
    * 标签管理
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class BaseTag implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键id
            */
    private String id;

            /**
            * 标签名：多个用,逗号隔开
            */
    private String name;

            /**
            * 资源Id
            */
    private String resourceId;

            /**
            * 资源
            */
    private String resource;

            /**
            * 顺序
            */
    private Integer orderNum;

            /**
            * 创建时间
            */
    private Date createTime;

            /**
            * 创建人
            */
    private String createPerson;

            /**
            * 创建人ID
            */
    private String createPersonIds;

            /**
            * 修改时间
            */
    private Date modifyTime;

            /**
            * 修改人
            */
    private String modifyPerson;

            /**
            * 修改人ID
            */
    private String modifyPersonIds;

            /**
            * 是否删除:0删除，1不删除
            */
    private Integer flagDelete;

            /**
            * 备注
            */
    private String remark;

            /**
            * json
            */
    private String dataJson;

        public String getId() {
        return id;
        }

            public void setId(String id) {
        this.id = id;
        }
        public String getName() {
        return name;
        }

            public void setName(String name) {
        this.name = name;
        }
        public String getResourceId() {
        return resourceId;
        }

            public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
        }
        public String getResource() {
        return resource;
        }

            public void setResource(String resource) {
        this.resource = resource;
        }
        public Integer getOrderNum() {
        return orderNum;
        }

            public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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
        public Integer getFlagDelete() {
        return flagDelete;
        }

            public void setFlagDelete(Integer flagDelete) {
        this.flagDelete = flagDelete;
        }
        public String getRemark() {
        return remark;
        }

            public void setRemark(String remark) {
        this.remark = remark;
        }
        public String getDataJson() {
        return dataJson;
        }

            public void setDataJson(String dataJson) {
        this.dataJson = dataJson;
        }

    @Override
    public String toString() {
    return "BaseTag{" +
            "id=" + id +
            ", name=" + name +
            ", resourceId=" + resourceId +
            ", resource=" + resource +
            ", orderNum=" + orderNum +
            ", createTime=" + createTime +
            ", createPerson=" + createPerson +
            ", createPersonIds=" + createPersonIds +
            ", modifyTime=" + modifyTime +
            ", modifyPerson=" + modifyPerson +
            ", modifyPersonIds=" + modifyPersonIds +
            ", flagDelete=" + flagDelete +
            ", remark=" + remark +
            ", dataJson=" + dataJson +
    "}";
    }
}
