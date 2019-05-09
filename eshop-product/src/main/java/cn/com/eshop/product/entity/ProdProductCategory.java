package cn.com.eshop.product.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 产品类别
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class ProdProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 类别名称
            */
    private String categoryName;

            /**
            * 类别编号
            */
    private String categoryCode;

            /**
            * 父模块
            */
    private String parentName;

            /**
            * 父code
            */
    private String parentCode;

            /**
            * code路径（包括自己）
            */
    private String parentPathCodes;

            /**
            * 排序
            */
    private Integer orderNum;

            /**
            * 是否删除:0否,1是
            */
    private Integer flagDelete;

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
            * 备注
            */
    private String remark;

        public Integer getId() {
        return id;
        }

            public void setId(Integer id) {
        this.id = id;
        }
        public String getCategoryName() {
        return categoryName;
        }

            public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        }
        public String getCategoryCode() {
        return categoryCode;
        }

            public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
        }
        public String getParentName() {
        return parentName;
        }

            public void setParentName(String parentName) {
        this.parentName = parentName;
        }
        public String getParentCode() {
        return parentCode;
        }

            public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
        }
        public String getParentPathCodes() {
        return parentPathCodes;
        }

            public void setParentPathCodes(String parentPathCodes) {
        this.parentPathCodes = parentPathCodes;
        }
        public Integer getOrderNum() {
        return orderNum;
        }

            public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
        }
        public Integer getFlagDelete() {
        return flagDelete;
        }

            public void setFlagDelete(Integer flagDelete) {
        this.flagDelete = flagDelete;
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
        public String getRemark() {
        return remark;
        }

            public void setRemark(String remark) {
        this.remark = remark;
        }

    @Override
    public String toString() {
    return "ProdProductCategory{" +
            "id=" + id +
            ", categoryName=" + categoryName +
            ", categoryCode=" + categoryCode +
            ", parentName=" + parentName +
            ", parentCode=" + parentCode +
            ", parentPathCodes=" + parentPathCodes +
            ", orderNum=" + orderNum +
            ", flagDelete=" + flagDelete +
            ", createTime=" + createTime +
            ", createBy=" + createBy +
            ", createByIds=" + createByIds +
            ", modifyTime=" + modifyTime +
            ", modifyBy=" + modifyBy +
            ", modifyByIds=" + modifyByIds +
            ", remark=" + remark +
    "}";
    }
}
