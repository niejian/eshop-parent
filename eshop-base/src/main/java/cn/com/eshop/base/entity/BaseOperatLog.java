package cn.com.eshop.base.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 操作日志记录
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class BaseOperatLog implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 模块编号:类的名称
            */
    private String module;

            /**
            * 请求类型request,function
            */
    private String logType;

            /**
            * 请求url
            */
    private String requestUrl;

            /**
            * 请求报文
            */
    private String requestData;

            /**
            * 响应报文
            */
    private String responseData;

            /**
            * 异常报文
            */
    private String exceptionData;

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
        public String getModule() {
        return module;
        }

            public void setModule(String module) {
        this.module = module;
        }
        public String getLogType() {
        return logType;
        }

            public void setLogType(String logType) {
        this.logType = logType;
        }
        public String getRequestUrl() {
        return requestUrl;
        }

            public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
        }
        public String getRequestData() {
        return requestData;
        }

            public void setRequestData(String requestData) {
        this.requestData = requestData;
        }
        public String getResponseData() {
        return responseData;
        }

            public void setResponseData(String responseData) {
        this.responseData = responseData;
        }
        public String getExceptionData() {
        return exceptionData;
        }

            public void setExceptionData(String exceptionData) {
        this.exceptionData = exceptionData;
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
    return "BaseOperatLog{" +
            "id=" + id +
            ", module=" + module +
            ", logType=" + logType +
            ", requestUrl=" + requestUrl +
            ", requestData=" + requestData +
            ", responseData=" + responseData +
            ", exceptionData=" + exceptionData +
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
