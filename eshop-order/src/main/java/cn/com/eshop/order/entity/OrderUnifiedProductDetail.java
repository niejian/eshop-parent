package cn.com.eshop.order.entity;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 统一产品明细表
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class OrderUnifiedProductDetail implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 店铺编号(tmail 天猫 jd 京东 suning 苏宁 yhd 一号店 wx 微信)
            */
    private String shopCode;

            /**
            * 订单号(店铺订单编号)
            */
    private String orderCode;

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
            * 是否赠品:0否,1是
            */
    private Integer flagPresent;

            /**
            * 销售价(元)
            */
    private BigDecimal price;

            /**
            * 成交金额(元)
            */
    private BigDecimal priceTotal;

            /**
            * 购买数量
            */
    private Integer quantity;

            /**
            * 店铺优惠金额
            */
    private BigDecimal priceDiscountShop;

            /**
            * 平台优惠金额
            */
    private BigDecimal priceDiscountPlatform;

            /**
            * 实付金额
            */
    private Integer priceActualPay;

            /**
            * 实收金额
            */
    private Integer priceActualReceipts;

            /**
            * 实收单价
            */
    private Integer priceActualUnit;

            /**
            * 运费
            */
    private BigDecimal pricePostage;

            /**
            * 是否变动过信息:0否,1是
            */
    private Integer flagChange;

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
        public String getShopCode() {
        return shopCode;
        }

            public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
        }
        public String getOrderCode() {
        return orderCode;
        }

            public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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
        public Integer getFlagPresent() {
        return flagPresent;
        }

            public void setFlagPresent(Integer flagPresent) {
        this.flagPresent = flagPresent;
        }
        public BigDecimal getPrice() {
        return price;
        }

            public void setPrice(BigDecimal price) {
        this.price = price;
        }
        public BigDecimal getPriceTotal() {
        return priceTotal;
        }

            public void setPriceTotal(BigDecimal priceTotal) {
        this.priceTotal = priceTotal;
        }
        public Integer getQuantity() {
        return quantity;
        }

            public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        }
        public BigDecimal getPriceDiscountShop() {
        return priceDiscountShop;
        }

            public void setPriceDiscountShop(BigDecimal priceDiscountShop) {
        this.priceDiscountShop = priceDiscountShop;
        }
        public BigDecimal getPriceDiscountPlatform() {
        return priceDiscountPlatform;
        }

            public void setPriceDiscountPlatform(BigDecimal priceDiscountPlatform) {
        this.priceDiscountPlatform = priceDiscountPlatform;
        }
        public Integer getPriceActualPay() {
        return priceActualPay;
        }

            public void setPriceActualPay(Integer priceActualPay) {
        this.priceActualPay = priceActualPay;
        }
        public Integer getPriceActualReceipts() {
        return priceActualReceipts;
        }

            public void setPriceActualReceipts(Integer priceActualReceipts) {
        this.priceActualReceipts = priceActualReceipts;
        }
        public Integer getPriceActualUnit() {
        return priceActualUnit;
        }

            public void setPriceActualUnit(Integer priceActualUnit) {
        this.priceActualUnit = priceActualUnit;
        }
        public BigDecimal getPricePostage() {
        return pricePostage;
        }

            public void setPricePostage(BigDecimal pricePostage) {
        this.pricePostage = pricePostage;
        }
        public Integer getFlagChange() {
        return flagChange;
        }

            public void setFlagChange(Integer flagChange) {
        this.flagChange = flagChange;
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
    return "OrderUnifiedProductDetail{" +
            "id=" + id +
            ", shopCode=" + shopCode +
            ", orderCode=" + orderCode +
            ", productCode=" + productCode +
            ", specification=" + specification +
            ", productName=" + productName +
            ", productUnit=" + productUnit +
            ", flagPresent=" + flagPresent +
            ", price=" + price +
            ", priceTotal=" + priceTotal +
            ", quantity=" + quantity +
            ", priceDiscountShop=" + priceDiscountShop +
            ", priceDiscountPlatform=" + priceDiscountPlatform +
            ", priceActualPay=" + priceActualPay +
            ", priceActualReceipts=" + priceActualReceipts +
            ", priceActualUnit=" + priceActualUnit +
            ", pricePostage=" + pricePostage +
            ", flagChange=" + flagChange +
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
