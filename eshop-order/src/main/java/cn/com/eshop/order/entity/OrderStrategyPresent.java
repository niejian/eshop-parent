package cn.com.eshop.order.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 赠品策略
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class OrderStrategyPresent implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 策略编号
            */
    private String presentCode;

            /**
            * 策略名称
            */
    private String presentName;

            /**
            * 所属平台编号：默认空，代表所有平台适用
            */
    private String platformCode;

            /**
            * 加赠类型：full_amount-满额送  full_piece-满件送  this_pro-指定商品送
            */
    private String presentType;

            /**
            * 开始时间
            */
    private Date startTime;

            /**
            * 结束时间
            */
    private Date endTime;

            /**
            * 状态start_time和end决定  convert_status: not_start未开始 ,running运行中 ,finished已结束
            */
    private String convertStatus;

            /**
            * 店铺转品总量店铺 (店铺转品限量，填写 -1代表不限量，按订单付款时间升序。)
            */
    private Integer limitNumOfShop;

            /**
            * 每单转品总量订单 (每个订单转品限量，填写 -1代表不限量。)
            */
    private Integer limitNumOfOrder;

            /**
            * 排除商品
            */
    private String excludeProductCode;

            /**
            * 包含商品
            */
    private String containProductCode;

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
        public String getPresentCode() {
        return presentCode;
        }

            public void setPresentCode(String presentCode) {
        this.presentCode = presentCode;
        }
        public String getPresentName() {
        return presentName;
        }

            public void setPresentName(String presentName) {
        this.presentName = presentName;
        }
        public String getPlatformCode() {
        return platformCode;
        }

            public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
        }
        public String getPresentType() {
        return presentType;
        }

            public void setPresentType(String presentType) {
        this.presentType = presentType;
        }
        public Date getStartTime() {
        return startTime;
        }

            public void setStartTime(Date startTime) {
        this.startTime = startTime;
        }
        public Date getEndTime() {
        return endTime;
        }

            public void setEndTime(Date endTime) {
        this.endTime = endTime;
        }
        public String getConvertStatus() {
        return convertStatus;
        }

            public void setConvertStatus(String convertStatus) {
        this.convertStatus = convertStatus;
        }
        public Integer getLimitNumOfShop() {
        return limitNumOfShop;
        }

            public void setLimitNumOfShop(Integer limitNumOfShop) {
        this.limitNumOfShop = limitNumOfShop;
        }
        public Integer getLimitNumOfOrder() {
        return limitNumOfOrder;
        }

            public void setLimitNumOfOrder(Integer limitNumOfOrder) {
        this.limitNumOfOrder = limitNumOfOrder;
        }
        public String getExcludeProductCode() {
        return excludeProductCode;
        }

            public void setExcludeProductCode(String excludeProductCode) {
        this.excludeProductCode = excludeProductCode;
        }
        public String getContainProductCode() {
        return containProductCode;
        }

            public void setContainProductCode(String containProductCode) {
        this.containProductCode = containProductCode;
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
    return "OrderStrategyPresent{" +
            "id=" + id +
            ", presentCode=" + presentCode +
            ", presentName=" + presentName +
            ", platformCode=" + platformCode +
            ", presentType=" + presentType +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", convertStatus=" + convertStatus +
            ", limitNumOfShop=" + limitNumOfShop +
            ", limitNumOfOrder=" + limitNumOfOrder +
            ", excludeProductCode=" + excludeProductCode +
            ", containProductCode=" + containProductCode +
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
