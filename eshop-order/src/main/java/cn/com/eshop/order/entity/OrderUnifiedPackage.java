package cn.com.eshop.order.entity;

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
    public class OrderUnifiedPackage implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 发货库存编号
            */
    private String storehouseCode;

            /**
            * 发货库存名称
            */
    private String storehouseName;

            /**
            * 包裹编号（快递单号）
            */
    private String packageCode;

            /**
            * 快递公司名称
            */
    private String logisticsName;

            /**
            * 快递公司编号
            */
    private String logisticsCode;

            /**
            * 快递单号：与package_code是对应的
            */
    private String logisticsNo;

            /**
            * 订单时间：取最早的订单中的时间
            */
    private Date orderDate;

            /**
            * 审单时间
            */
    private Date verifyDate;

            /**
            * 审单人
            */
    private String verifyBy;

            /**
            * 审单人ID
            */
    private String verifyByIds;

            /**
            * 验货时间
            */
    private Date examineDate;

            /**
            * 验货人
            */
    private String examineBy;

            /**
            * 验货人ID
            */
    private String examineByIds;

            /**
            * 打印时间
            */
    private Date printDate;

            /**
            * 发货时间
            */
    private Date deliveryDate;

            /**
            * 计划到货日期
            */
    private Date planArrivalDate;

            /**
            * 实际到货日期
            */
    private Date realArrivalDate;

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
        public String getPackageCode() {
        return packageCode;
        }

            public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
        }
        public String getLogisticsName() {
        return logisticsName;
        }

            public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
        }
        public String getLogisticsCode() {
        return logisticsCode;
        }

            public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
        }
        public String getLogisticsNo() {
        return logisticsNo;
        }

            public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
        }
        public Date getOrderDate() {
        return orderDate;
        }

            public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        }
        public Date getVerifyDate() {
        return verifyDate;
        }

            public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
        }
        public String getVerifyBy() {
        return verifyBy;
        }

            public void setVerifyBy(String verifyBy) {
        this.verifyBy = verifyBy;
        }
        public String getVerifyByIds() {
        return verifyByIds;
        }

            public void setVerifyByIds(String verifyByIds) {
        this.verifyByIds = verifyByIds;
        }
        public Date getExamineDate() {
        return examineDate;
        }

            public void setExamineDate(Date examineDate) {
        this.examineDate = examineDate;
        }
        public String getExamineBy() {
        return examineBy;
        }

            public void setExamineBy(String examineBy) {
        this.examineBy = examineBy;
        }
        public String getExamineByIds() {
        return examineByIds;
        }

            public void setExamineByIds(String examineByIds) {
        this.examineByIds = examineByIds;
        }
        public Date getPrintDate() {
        return printDate;
        }

            public void setPrintDate(Date printDate) {
        this.printDate = printDate;
        }
        public Date getDeliveryDate() {
        return deliveryDate;
        }

            public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
        }
        public Date getPlanArrivalDate() {
        return planArrivalDate;
        }

            public void setPlanArrivalDate(Date planArrivalDate) {
        this.planArrivalDate = planArrivalDate;
        }
        public Date getRealArrivalDate() {
        return realArrivalDate;
        }

            public void setRealArrivalDate(Date realArrivalDate) {
        this.realArrivalDate = realArrivalDate;
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
    return "OrderUnifiedPackage{" +
            "id=" + id +
            ", storehouseCode=" + storehouseCode +
            ", storehouseName=" + storehouseName +
            ", packageCode=" + packageCode +
            ", logisticsName=" + logisticsName +
            ", logisticsCode=" + logisticsCode +
            ", logisticsNo=" + logisticsNo +
            ", orderDate=" + orderDate +
            ", verifyDate=" + verifyDate +
            ", verifyBy=" + verifyBy +
            ", verifyByIds=" + verifyByIds +
            ", examineDate=" + examineDate +
            ", examineBy=" + examineBy +
            ", examineByIds=" + examineByIds +
            ", printDate=" + printDate +
            ", deliveryDate=" + deliveryDate +
            ", planArrivalDate=" + planArrivalDate +
            ", realArrivalDate=" + realArrivalDate +
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
