package cn.com.eshop.order.entity;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 统一包裹明细表
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class OrderUnifiedPackageDetail implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 包裹编号（快递单号）
            */
    private String packageCode;

            /**
            * 订单号(店铺订单编号)
            */
    private String orderCode;

            /**
            * 产品类型（单品、赠品、套餐）
            */
    private String productType;

            /**
            * 产品编号
            */
    private String productCode;

            /**
            * 规格型号
            */
    private String specification;

            /**
            * 产品名称
            */
    private String productName;

            /**
            * 计量单位:(字典：product_unit)branch-支、bottle-瓶、set-套、group-组、box-箱
            */
    private String productUnit;

            /**
            * 零售价(元)
            */
    private BigDecimal price;

            /**
            * 数量
            */
    private Integer productNum;

            /**
            * 损坏理赔价(元):默认为0取实际交易金额
            */
    private BigDecimal priceOfClaim;

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
        public String getPackageCode() {
        return packageCode;
        }

            public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
        }
        public String getOrderCode() {
        return orderCode;
        }

            public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
        }
        public String getProductType() {
        return productType;
        }

            public void setProductType(String productType) {
        this.productType = productType;
        }
        public String getProductCode() {
        return productCode;
        }

            public void setProductCode(String productCode) {
        this.productCode = productCode;
        }
        public String getSpecification() {
        return specification;
        }

            public void setSpecification(String specification) {
        this.specification = specification;
        }
        public String getProductName() {
        return productName;
        }

            public void setProductName(String productName) {
        this.productName = productName;
        }
        public String getProductUnit() {
        return productUnit;
        }

            public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
        }
        public BigDecimal getPrice() {
        return price;
        }

            public void setPrice(BigDecimal price) {
        this.price = price;
        }
        public Integer getProductNum() {
        return productNum;
        }

            public void setProductNum(Integer productNum) {
        this.productNum = productNum;
        }
        public BigDecimal getPriceOfClaim() {
        return priceOfClaim;
        }

            public void setPriceOfClaim(BigDecimal priceOfClaim) {
        this.priceOfClaim = priceOfClaim;
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
    return "OrderUnifiedPackageDetail{" +
            "id=" + id +
            ", packageCode=" + packageCode +
            ", orderCode=" + orderCode +
            ", productType=" + productType +
            ", productCode=" + productCode +
            ", specification=" + specification +
            ", productName=" + productName +
            ", productUnit=" + productUnit +
            ", price=" + price +
            ", productNum=" + productNum +
            ", priceOfClaim=" + priceOfClaim +
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
