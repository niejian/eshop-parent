package cn.com.eshop.base.entity;

    import java.util.Date;
    import java.io.Serializable;

/**
* <p>
    * 图片大小
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class BasePictureSize implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键id
            */
    private String id;

            /**
            * 图片类别
            */
    private String name;

            /**
            * 宽
            */
    private Integer width;

            /**
            * 高
            */
    private Integer height;

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
        public Integer getWidth() {
        return width;
        }

            public void setWidth(Integer width) {
        this.width = width;
        }
        public Integer getHeight() {
        return height;
        }

            public void setHeight(Integer height) {
        this.height = height;
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
    return "BasePictureSize{" +
            "id=" + id +
            ", name=" + name +
            ", width=" + width +
            ", height=" + height +
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
