package cn.com.eshop.order.entity;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableField;
    import java.io.Serializable;

/**
* <p>
    * 统一订单
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class OrderUnifiedOrder implements Serializable {

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
            * 状态步骤:购物,结算,已付款,取消,退货,收货
            */
    private String status;

            /**
            * 卖家Id
            */
        @TableField("buyer_Id")
    private String buyerId;

            /**
            * 买家昵称
            */
    private String buyerNick;

            /**
            * 卖家电话
            */
    private String buyerTel;

            /**
            * 卖家手机号
            */
    private String buyerMobile;

            /**
            * 卖家email
            */
    private String buyerEmail;

            /**
            * 卖家备注
            */
    private String buyerRemark;

            /**
            * 品种数
            */
    private Integer varietyNum;

            /**
            * 产品总件数
            */
    private Integer productTotalNum;

            /**
            * 商品总价格
            */
    private BigDecimal priceTotal;

            /**
            * 店铺优惠金额
            */
    private BigDecimal priceDiscountShop;

            /**
            * 平台承担优惠金额
            */
    private BigDecimal priceDiscountPlatform;

            /**
            * 邮费
            */
    private BigDecimal priceTotalPost;

            /**
            * 调整后金额
            */
    private BigDecimal priceTotalAdjust;

            /**
            * 实支付金额
            */
    private BigDecimal priceTotalActualPay;

            /**
            * 支付时间
            */
    private Date payTime;

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
        public String getStatus() {
        return status;
        }

            public void setStatus(String status) {
        this.status = status;
        }
        public String getBuyerId() {
        return buyerId;
        }

            public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
        }
        public String getBuyerNick() {
        return buyerNick;
        }

            public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
        }
        public String getBuyerTel() {
        return buyerTel;
        }

            public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel;
        }
        public String getBuyerMobile() {
        return buyerMobile;
        }

            public void setBuyerMobile(String buyerMobile) {
        this.buyerMobile = buyerMobile;
        }
        public String getBuyerEmail() {
        return buyerEmail;
        }

            public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
        }
        public String getBuyerRemark() {
        return buyerRemark;
        }

            public void setBuyerRemark(String buyerRemark) {
        this.buyerRemark = buyerRemark;
        }
        public Integer getVarietyNum() {
        return varietyNum;
        }

            public void setVarietyNum(Integer varietyNum) {
        this.varietyNum = varietyNum;
        }
        public Integer getProductTotalNum() {
        return productTotalNum;
        }

            public void setProductTotalNum(Integer productTotalNum) {
        this.productTotalNum = productTotalNum;
        }
        public BigDecimal getPriceTotal() {
        return priceTotal;
        }

            public void setPriceTotal(BigDecimal priceTotal) {
        this.priceTotal = priceTotal;
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
        public BigDecimal getPriceTotalPost() {
        return priceTotalPost;
        }

            public void setPriceTotalPost(BigDecimal priceTotalPost) {
        this.priceTotalPost = priceTotalPost;
        }
        public BigDecimal getPriceTotalAdjust() {
        return priceTotalAdjust;
        }

            public void setPriceTotalAdjust(BigDecimal priceTotalAdjust) {
        this.priceTotalAdjust = priceTotalAdjust;
        }
        public BigDecimal getPriceTotalActualPay() {
        return priceTotalActualPay;
        }

            public void setPriceTotalActualPay(BigDecimal priceTotalActualPay) {
        this.priceTotalActualPay = priceTotalActualPay;
        }
        public Date getPayTime() {
        return payTime;
        }

            public void setPayTime(Date payTime) {
        this.payTime = payTime;
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
    return "OrderUnifiedOrder{" +
            "id=" + id +
            ", shopCode=" + shopCode +
            ", orderCode=" + orderCode +
            ", status=" + status +
            ", buyerId=" + buyerId +
            ", buyerNick=" + buyerNick +
            ", buyerTel=" + buyerTel +
            ", buyerMobile=" + buyerMobile +
            ", buyerEmail=" + buyerEmail +
            ", buyerRemark=" + buyerRemark +
            ", varietyNum=" + varietyNum +
            ", productTotalNum=" + productTotalNum +
            ", priceTotal=" + priceTotal +
            ", priceDiscountShop=" + priceDiscountShop +
            ", priceDiscountPlatform=" + priceDiscountPlatform +
            ", priceTotalPost=" + priceTotalPost +
            ", priceTotalAdjust=" + priceTotalAdjust +
            ", priceTotalActualPay=" + priceTotalActualPay +
            ", payTime=" + payTime +
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
