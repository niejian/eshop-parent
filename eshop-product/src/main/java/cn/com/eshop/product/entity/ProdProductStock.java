package cn.com.eshop.product.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 产品库存
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class ProdProductStock implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 库存编号
            */
    private String storehouseCode;

            /**
            * 库存名称
            */
    private String storehouseName;

            /**
            * 产品编号
            */
    private String productCode;

            /**
            * 产品名称(对内)
            */
    private String productName;

            /**
            * 规格型号
            */
    private String specification;

            /**
            * 入库批次
            */
    private String batchNo;

            /**
            * 有效日期
            */
    private Date lifeCycleTimeStart;

            /**
            * 失效日期
            */
    private Date lifeCycleTimeEnd;

            /**
            * 数量
            */
    private Integer productNum;

            /**
            * 排序
            */
    private Integer orderNum;

            /**
            * 是否冻结:0否,1是
            */
    private Integer flagFrozen;

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
        public String getStorehouseCode() {
        return storehouseCode;
        }

            public void setStorehouseCode(String storehouseCode) {
        this.storehouseCode = storehouseCode;
        }
        public String getStorehouseName() {
        return storehouseName;
        }

            public void setStorehouseName(String storehouseName) {
        this.storehouseName = storehouseName;
        }
        public String getProductCode() {
        return productCode;
        }

            public void setProductCode(String productCode) {
        this.productCode = productCode;
        }
        public String getProductName() {
        return productName;
        }

            public void setProductName(String productName) {
        this.productName = productName;
        }
        public String getSpecification() {
        return specification;
        }

            public void setSpecification(String specification) {
        this.specification = specification;
        }
        public String getBatchNo() {
        return batchNo;
        }

            public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
        }
        public Date getLifeCycleTimeStart() {
        return lifeCycleTimeStart;
        }

            public void setLifeCycleTimeStart(Date lifeCycleTimeStart) {
        this.lifeCycleTimeStart = lifeCycleTimeStart;
        }
        public Date getLifeCycleTimeEnd() {
        return lifeCycleTimeEnd;
        }

            public void setLifeCycleTimeEnd(Date lifeCycleTimeEnd) {
        this.lifeCycleTimeEnd = lifeCycleTimeEnd;
        }
        public Integer getProductNum() {
        return productNum;
        }

            public void setProductNum(Integer productNum) {
        this.productNum = productNum;
        }
        public Integer getOrderNum() {
        return orderNum;
        }

            public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
        }
        public Integer getFlagFrozen() {
        return flagFrozen;
        }

            public void setFlagFrozen(Integer flagFrozen) {
        this.flagFrozen = flagFrozen;
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
    return "ProdProductStock{" +
            "id=" + id +
            ", storehouseCode=" + storehouseCode +
            ", storehouseName=" + storehouseName +
            ", productCode=" + productCode +
            ", productName=" + productName +
            ", specification=" + specification +
            ", batchNo=" + batchNo +
            ", lifeCycleTimeStart=" + lifeCycleTimeStart +
            ", lifeCycleTimeEnd=" + lifeCycleTimeEnd +
            ", productNum=" + productNum +
            ", orderNum=" + orderNum +
            ", flagFrozen=" + flagFrozen +
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
