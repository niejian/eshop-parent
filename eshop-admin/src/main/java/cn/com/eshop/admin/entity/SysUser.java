package cn.com.eshop.admin.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
* <p>
    * 用户表
    * </p>
*
* @author code4fun
* @since 2019-05-19
*/
@JsonIgnoreProperties({"userPassword"})
    public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String userCode;

    private String userName;

    private String userNickName;

    private String userPassword;

            /**
            * 头像信息
            */
    private String avatar;
    private Boolean deleteFlag;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

    private String createBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date modifyTime;

    private String modifyBy;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Long getId() {
        return id;
        }

            public void setId(Long id) {
        this.id = id;
        }
        public String getUserCode() {
        return userCode;
        }

            public void setUserCode(String userCode) {
        this.userCode = userCode;
        }
        public String getUserName() {
        return userName;
        }

            public void setUserName(String userName) {
        this.userName = userName;
        }
        public String getUserNickName() {
        return userNickName;
        }

            public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
        }
        public String getAvatar() {
        return avatar;
        }

            public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    @Override
    public String toString() {
    return "SysUser{" +
            "id=" + id +
            ", userCode=" + userCode +
            ", userName=" + userName +
            ", userNickName=" + userNickName +
            ", avatar=" + avatar +
            ", createTime=" + createTime +
            ", createBy=" + createBy +
            ", modifyTime=" + modifyTime +
            ", modifyBy=" + modifyBy +
    "}";
    }
}
