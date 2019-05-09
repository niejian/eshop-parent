package cn.com.eshop.base.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 短信或推送信息
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class BaseMessageSms implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 调用帐号
            */
    private String myAccount;

            /**
            * 调用方描述:洗衣项目调用短信
            */
    private String myRemark;

            /**
            * 接收方:系统平台
            */
    private String platform;

            /**
            * 接收方:手机号,手机端标识
            */
    private String mobileNo;

            /**
            * 内容
            */
    private String content;

            /**
            * 发送状态:成功,失败,等待:success,fail,wait
            */
    private String sendStatus;

            /**
            * 发送次数
            */
    private Integer sendNum;

            /**
            * 是否紧急的::0否,1是
            */
    private Integer flagUrgent;

            /**
            * 是否可以多次尝试:0否,1是
            */
    private Integer flagTryAgain;

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
        public String getMyAccount() {
        return myAccount;
        }

            public void setMyAccount(String myAccount) {
        this.myAccount = myAccount;
        }
        public String getMyRemark() {
        return myRemark;
        }

            public void setMyRemark(String myRemark) {
        this.myRemark = myRemark;
        }
        public String getPlatform() {
        return platform;
        }

            public void setPlatform(String platform) {
        this.platform = platform;
        }
        public String getMobileNo() {
        return mobileNo;
        }

            public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        }
        public String getContent() {
        return content;
        }

            public void setContent(String content) {
        this.content = content;
        }
        public String getSendStatus() {
        return sendStatus;
        }

            public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
        }
        public Integer getSendNum() {
        return sendNum;
        }

            public void setSendNum(Integer sendNum) {
        this.sendNum = sendNum;
        }
        public Integer getFlagUrgent() {
        return flagUrgent;
        }

            public void setFlagUrgent(Integer flagUrgent) {
        this.flagUrgent = flagUrgent;
        }
        public Integer getFlagTryAgain() {
        return flagTryAgain;
        }

            public void setFlagTryAgain(Integer flagTryAgain) {
        this.flagTryAgain = flagTryAgain;
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
    return "BaseMessageSms{" +
            "id=" + id +
            ", myAccount=" + myAccount +
            ", myRemark=" + myRemark +
            ", platform=" + platform +
            ", mobileNo=" + mobileNo +
            ", content=" + content +
            ", sendStatus=" + sendStatus +
            ", sendNum=" + sendNum +
            ", flagUrgent=" + flagUrgent +
            ", flagTryAgain=" + flagTryAgain +
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
