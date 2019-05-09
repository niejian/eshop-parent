package cn.com.eshop.base.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 附件管理
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class BaseAttachment implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 模块编号:类的名称
            */
    private String module;

            /**
            * 附件路径
            */
    private String path;

            /**
            * 附件名称
            */
    private String name;

            /**
            * 文件名
            */
    private String fileName;

            /**
            * 下载次数
            */
    private Integer downCount;

            /**
            * 附件大小
            */
    private Integer size;

            /**
            * 附件类型 相册（photo） 文件（ file）
            */
    private String fileType;

            /**
            * 链接
            */
    private String link;

            /**
            * 是否冻结:0否,1是
            */
    private Integer flagFrozen;

            /**
            * 排序
            */
    private Integer orderNum;

            /**
            * 创建时间
            */
    private Date createTime;

            /**
            * 创建人
            */
    private String createBy;

            /**
            * 创建人ID
            */
    private String createByIds;

            /**
            * 修改时间
            */
    private Date modifyTime;

            /**
            * 修改人
            */
    private String modifyBy;

            /**
            * 修改人ID
            */
    private String modifyByIds;

            /**
            * 是否删除:0否,1是
            */
    private Integer flagDelete;

            /**
            * 备注
            */
    private String remark;

        public Integer getId() {
        return id;
        }

            public void setId(Integer id) {
        this.id = id;
        }
        public String getModule() {
        return module;
        }

            public void setModule(String module) {
        this.module = module;
        }
        public String getPath() {
        return path;
        }

            public void setPath(String path) {
        this.path = path;
        }
        public String getName() {
        return name;
        }

            public void setName(String name) {
        this.name = name;
        }
        public String getFileName() {
        return fileName;
        }

            public void setFileName(String fileName) {
        this.fileName = fileName;
        }
        public Integer getDownCount() {
        return downCount;
        }

            public void setDownCount(Integer downCount) {
        this.downCount = downCount;
        }
        public Integer getSize() {
        return size;
        }

            public void setSize(Integer size) {
        this.size = size;
        }
        public String getFileType() {
        return fileType;
        }

            public void setFileType(String fileType) {
        this.fileType = fileType;
        }
        public String getLink() {
        return link;
        }

            public void setLink(String link) {
        this.link = link;
        }
        public Integer getFlagFrozen() {
        return flagFrozen;
        }

            public void setFlagFrozen(Integer flagFrozen) {
        this.flagFrozen = flagFrozen;
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
        public String getCreateBy() {
        return createBy;
        }

            public void setCreateBy(String createBy) {
        this.createBy = createBy;
        }
        public String getCreateByIds() {
        return createByIds;
        }

            public void setCreateByIds(String createByIds) {
        this.createByIds = createByIds;
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
        public String getModifyByIds() {
        return modifyByIds;
        }

            public void setModifyByIds(String modifyByIds) {
        this.modifyByIds = modifyByIds;
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

    @Override
    public String toString() {
    return "BaseAttachment{" +
            "id=" + id +
            ", module=" + module +
            ", path=" + path +
            ", name=" + name +
            ", fileName=" + fileName +
            ", downCount=" + downCount +
            ", size=" + size +
            ", fileType=" + fileType +
            ", link=" + link +
            ", flagFrozen=" + flagFrozen +
            ", orderNum=" + orderNum +
            ", createTime=" + createTime +
            ", createBy=" + createBy +
            ", createByIds=" + createByIds +
            ", modifyTime=" + modifyTime +
            ", modifyBy=" + modifyBy +
            ", modifyByIds=" + modifyByIds +
            ", flagDelete=" + flagDelete +
            ", remark=" + remark +
    "}";
    }
}
