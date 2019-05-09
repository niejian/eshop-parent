package cn.com.eshop.base.entity;

    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableField;
    import java.io.Serializable;

/**
* <p>
    * 收货地址
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class BaseAddress implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键id
            */
    private String id;

            /**
            * 详细地址
            */
    private String address1Hand;

    private String address2SystemText;

            /**
            * 系统地址
            */
    private String address2System;

            /**
            * 地区
            */
        @TableField("areaIds")
    private String areaIds;

            /**
            * 收货人
            */
    private String person;

            /**
            * 电话
            */
    private String tel;

            /**
            * 手机号
            */
    private String mobile;

            /**
            * 用户ID
            */
    private String userId;

            /**
            * email
            */
    private String email;

            /**
            * 邮政编码
            */
    private String zip;

            /**
            * 是否默认收货地址:0否,1是
            */
    private Integer flagDefault;

            /**
            * 创建时间
            */
    private Date createTime;

            /**
            * 创建人
            */
    private String createPerson;

            /**
            * 创建人ID
            */
    private String createPersonIds;

            /**
            * 修改时间
            */
    private Date modifyTime;

            /**
            * 修改人
            */
    private String modifyPerson;

            /**
            * 修改人ID
            */
    private String modifyPersonIds;

            /**
            * 是否删除:N否,Y是
            */
    private String flagDelete;

            /**
            * 备注
            */
    private String remark;

            /**
            * json
            */
    private String dataJson;

        public String getId() {
        return id;
        }

            public void setId(String id) {
        this.id = id;
        }
        public String getAddress1Hand() {
        return address1Hand;
        }

            public void setAddress1Hand(String address1Hand) {
        this.address1Hand = address1Hand;
        }
        public String getAddress2SystemText() {
        return address2SystemText;
        }

            public void setAddress2SystemText(String address2SystemText) {
        this.address2SystemText = address2SystemText;
        }
        public String getAddress2System() {
        return address2System;
        }

            public void setAddress2System(String address2System) {
        this.address2System = address2System;
        }
        public String getAreaIds() {
        return areaIds;
        }

            public void setAreaIds(String areaIds) {
        this.areaIds = areaIds;
        }
        public String getPerson() {
        return person;
        }

            public void setPerson(String person) {
        this.person = person;
        }
        public String getTel() {
        return tel;
        }

            public void setTel(String tel) {
        this.tel = tel;
        }
        public String getMobile() {
        return mobile;
        }

            public void setMobile(String mobile) {
        this.mobile = mobile;
        }
        public String getUserId() {
        return userId;
        }

            public void setUserId(String userId) {
        this.userId = userId;
        }
        public String getEmail() {
        return email;
        }

            public void setEmail(String email) {
        this.email = email;
        }
        public String getZip() {
        return zip;
        }

            public void setZip(String zip) {
        this.zip = zip;
        }
        public Integer getFlagDefault() {
        return flagDefault;
        }

            public void setFlagDefault(Integer flagDefault) {
        this.flagDefault = flagDefault;
        }
        public Date getCreateTime() {
        return createTime;
        }

            public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        }
        public String getCreatePerson() {
        return createPerson;
        }

            public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
        }
        public String getCreatePersonIds() {
        return createPersonIds;
        }

            public void setCreatePersonIds(String createPersonIds) {
        this.createPersonIds = createPersonIds;
        }
        public Date getModifyTime() {
        return modifyTime;
        }

            public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
        }
        public String getModifyPerson() {
        return modifyPerson;
        }

            public void setModifyPerson(String modifyPerson) {
        this.modifyPerson = modifyPerson;
        }
        public String getModifyPersonIds() {
        return modifyPersonIds;
        }

            public void setModifyPersonIds(String modifyPersonIds) {
        this.modifyPersonIds = modifyPersonIds;
        }
        public String getFlagDelete() {
        return flagDelete;
        }

            public void setFlagDelete(String flagDelete) {
        this.flagDelete = flagDelete;
        }
        public String getRemark() {
        return remark;
        }

            public void setRemark(String remark) {
        this.remark = remark;
        }
        public String getDataJson() {
        return dataJson;
        }

            public void setDataJson(String dataJson) {
        this.dataJson = dataJson;
        }

    @Override
    public String toString() {
    return "BaseAddress{" +
            "id=" + id +
            ", address1Hand=" + address1Hand +
            ", address2SystemText=" + address2SystemText +
            ", address2System=" + address2System +
            ", areaIds=" + areaIds +
            ", person=" + person +
            ", tel=" + tel +
            ", mobile=" + mobile +
            ", userId=" + userId +
            ", email=" + email +
            ", zip=" + zip +
            ", flagDefault=" + flagDefault +
            ", createTime=" + createTime +
            ", createPerson=" + createPerson +
            ", createPersonIds=" + createPersonIds +
            ", modifyTime=" + modifyTime +
            ", modifyPerson=" + modifyPerson +
            ", modifyPersonIds=" + modifyPersonIds +
            ", flagDelete=" + flagDelete +
            ", remark=" + remark +
            ", dataJson=" + dataJson +
    "}";
    }
}
