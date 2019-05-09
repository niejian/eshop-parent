package cn.com.eshop.base.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 字典项
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class BaseDictAttr implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 字典标识
            */
    private String dictCode;

            /**
            * 字典名称
            */
    private String dictName;

            /**
            * 子项编码
            */
    private String code;

            /**
            * 子项名称
            */
    private String name;

            /**
            * 语言:en_US,zh_CN
            */
    private String locale;

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
        public String getDictCode() {
        return dictCode;
        }

            public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
        }
        public String getDictName() {
        return dictName;
        }

            public void setDictName(String dictName) {
        this.dictName = dictName;
        }
        public String getCode() {
        return code;
        }

            public void setCode(String code) {
        this.code = code;
        }
        public String getName() {
        return name;
        }

            public void setName(String name) {
        this.name = name;
        }
        public String getLocale() {
        return locale;
        }

            public void setLocale(String locale) {
        this.locale = locale;
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
    return "BaseDictAttr{" +
            "id=" + id +
            ", dictCode=" + dictCode +
            ", dictName=" + dictName +
            ", code=" + code +
            ", name=" + name +
            ", locale=" + locale +
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
