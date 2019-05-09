package cn.com.eshop.order.entity;

    import java.math.BigDecimal;
    import java.util.Date;
    import java.io.Serializable;

/**
* <p>
    * 统一订单扩展
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class OrderUnifiedOrderExtend implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * unified_order主键ID
            */
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
            * 是否退款:0否,1是
            */
    private Integer refundFlag;

            /**
            * 退款总金额
            */
    private BigDecimal refundPriceTotal;

            /**
            * 退款状态：process退款中，success成功， fail失败 
            */
    private String refundStatus;

            /**
            * 退款备注
            */
    private String refundRemark;

            /**
            * 开票invoice_buyer ：-1 对于商家对个人开具为 0；对于商家对企业开具为 1；
            */
    private Integer invoiceBuyer;

            /**
            * 发票类型：增值税专用发票（纸质）,增值税普通发票（纸质）,增值税普通发票（电子） ->page_special_invoice，page_invoice，elec_invoice
            */
    private String invoiceType;

            /**
            * 发票台头
            */
    private String invoiceTitle;

            /**
            * 发票状态：process开票中，success成功， fail失败 
            */
    private String invoiceStatus;

            /**
            * 退款备注
            */
    private String invoiceRemark;

            /**
            * 收货人姓名
            */
    private String receiverName;

            /**
            * 收货人手机
            */
    private String receiverMobile;

            /**
            * 收货人固定电话
            */
    private String receiverPhone;

            /**
            * 邮政编码
            */
    private String receiverPostCode;

            /**
            * 收货人国籍
            */
    private String receiverCountry;

            /**
            * 收货人省份
            */
    private String receiverProvince;

            /**
            * 收货人城市
            */
    private String receiverCity;

            /**
            * 收货人区县
            */
    private String receiverCounty;

            /**
            * 收货人城镇
            */
    private String receiverTown;

            /**
            * 收货人详细地址
            */
    private String receiverAddress;

            /**
            * 发货类型（快递  自提 其它 logistics, self_service, other）
            */
    private String logisticsType;

            /**
            * 发货状态 （字典：logistics_status）send_ready-准备中 send_wait-待发货 send_do-发货中 send_out-已发货 signed-已签收 exception-异常
            */
    private String logisticsStatus;

            /**
            * 发货备注
            */
    private String logisticsRemark;

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
        public Integer getRefundFlag() {
        return refundFlag;
        }

            public void setRefundFlag(Integer refundFlag) {
        this.refundFlag = refundFlag;
        }
        public BigDecimal getRefundPriceTotal() {
        return refundPriceTotal;
        }

            public void setRefundPriceTotal(BigDecimal refundPriceTotal) {
        this.refundPriceTotal = refundPriceTotal;
        }
        public String getRefundStatus() {
        return refundStatus;
        }

            public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
        }
        public String getRefundRemark() {
        return refundRemark;
        }

            public void setRefundRemark(String refundRemark) {
        this.refundRemark = refundRemark;
        }
        public Integer getInvoiceBuyer() {
        return invoiceBuyer;
        }

            public void setInvoiceBuyer(Integer invoiceBuyer) {
        this.invoiceBuyer = invoiceBuyer;
        }
        public String getInvoiceType() {
        return invoiceType;
        }

            public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
        }
        public String getInvoiceTitle() {
        return invoiceTitle;
        }

            public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
        }
        public String getInvoiceStatus() {
        return invoiceStatus;
        }

            public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
        }
        public String getInvoiceRemark() {
        return invoiceRemark;
        }

            public void setInvoiceRemark(String invoiceRemark) {
        this.invoiceRemark = invoiceRemark;
        }
        public String getReceiverName() {
        return receiverName;
        }

            public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
        }
        public String getReceiverMobile() {
        return receiverMobile;
        }

            public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
        }
        public String getReceiverPhone() {
        return receiverPhone;
        }

            public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
        }
        public String getReceiverPostCode() {
        return receiverPostCode;
        }

            public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
        }
        public String getReceiverCountry() {
        return receiverCountry;
        }

            public void setReceiverCountry(String receiverCountry) {
        this.receiverCountry = receiverCountry;
        }
        public String getReceiverProvince() {
        return receiverProvince;
        }

            public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
        }
        public String getReceiverCity() {
        return receiverCity;
        }

            public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
        }
        public String getReceiverCounty() {
        return receiverCounty;
        }

            public void setReceiverCounty(String receiverCounty) {
        this.receiverCounty = receiverCounty;
        }
        public String getReceiverTown() {
        return receiverTown;
        }

            public void setReceiverTown(String receiverTown) {
        this.receiverTown = receiverTown;
        }
        public String getReceiverAddress() {
        return receiverAddress;
        }

            public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
        }
        public String getLogisticsType() {
        return logisticsType;
        }

            public void setLogisticsType(String logisticsType) {
        this.logisticsType = logisticsType;
        }
        public String getLogisticsStatus() {
        return logisticsStatus;
        }

            public void setLogisticsStatus(String logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
        }
        public String getLogisticsRemark() {
        return logisticsRemark;
        }

            public void setLogisticsRemark(String logisticsRemark) {
        this.logisticsRemark = logisticsRemark;
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
    return "OrderUnifiedOrderExtend{" +
            "id=" + id +
            ", shopCode=" + shopCode +
            ", orderCode=" + orderCode +
            ", refundFlag=" + refundFlag +
            ", refundPriceTotal=" + refundPriceTotal +
            ", refundStatus=" + refundStatus +
            ", refundRemark=" + refundRemark +
            ", invoiceBuyer=" + invoiceBuyer +
            ", invoiceType=" + invoiceType +
            ", invoiceTitle=" + invoiceTitle +
            ", invoiceStatus=" + invoiceStatus +
            ", invoiceRemark=" + invoiceRemark +
            ", receiverName=" + receiverName +
            ", receiverMobile=" + receiverMobile +
            ", receiverPhone=" + receiverPhone +
            ", receiverPostCode=" + receiverPostCode +
            ", receiverCountry=" + receiverCountry +
            ", receiverProvince=" + receiverProvince +
            ", receiverCity=" + receiverCity +
            ", receiverCounty=" + receiverCounty +
            ", receiverTown=" + receiverTown +
            ", receiverAddress=" + receiverAddress +
            ", logisticsType=" + logisticsType +
            ", logisticsStatus=" + logisticsStatus +
            ", logisticsRemark=" + logisticsRemark +
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
