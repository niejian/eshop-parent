package cn.com.eshop.order.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 快递公司
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class OrderBaseLogistics implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 快递代码
            */
    private String code;

            /**
            * 快递公司
            */
    private String name;

            /**
            * 验证运单号正则表达式
            */
    private String regularNo;

            /**
            * 结款方式 logistics_pay_type : week-周结  month-月结  season-季节
            */
    private String logisticsPayType;

            /**
            * 是否支持货到付款:0否,1是
            */
    private Integer flagCash;

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
        public String getRegularNo() {
        return regularNo;
        }

            public void setRegularNo(String regularNo) {
        this.regularNo = regularNo;
        }
        public String getLogisticsPayType() {
        return logisticsPayType;
        }

            public void setLogisticsPayType(String logisticsPayType) {
        this.logisticsPayType = logisticsPayType;
        }
        public Integer getFlagCash() {
        return flagCash;
        }

            public void setFlagCash(Integer flagCash) {
        this.flagCash = flagCash;
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
    return "OrderBaseLogistics{" +
            "id=" + id +
            ", code=" + code +
            ", name=" + name +
            ", regularNo=" + regularNo +
            ", logisticsPayType=" + logisticsPayType +
            ", flagCash=" + flagCash +
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
