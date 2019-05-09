package cn.com.eshop.base.entity;

    import java.util.Date;
    import java.io.Serializable;

/**
* <p>
    * 评论
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class BaseComment implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键id
            */
    private String id;

            /**
            * 被评论的资源Id
            */
    private String resourceId;

            /**
            * resource
            */
    private String resource;

            /**
            * 评论内容
            */
    private String content;

            /**
            * 几颗星:1~5
            */
    private Integer star;

            /**
            * 图片（数组）
            */
    private String imgs;

            /**
            * 子评论
            */
    private String parentCommentId;

            /**
            * 回复内容
            */
    private String reply;

            /**
            * 回复时间
            */
    private Date replyDate;

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
            * 是否删除:0删除，1不删除
            */
    private Integer flagDelete;

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
        public String getResourceId() {
        return resourceId;
        }

            public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
        }
        public String getResource() {
        return resource;
        }

            public void setResource(String resource) {
        this.resource = resource;
        }
        public String getContent() {
        return content;
        }

            public void setContent(String content) {
        this.content = content;
        }
        public Integer getStar() {
        return star;
        }

            public void setStar(Integer star) {
        this.star = star;
        }
        public String getImgs() {
        return imgs;
        }

            public void setImgs(String imgs) {
        this.imgs = imgs;
        }
        public String getParentCommentId() {
        return parentCommentId;
        }

            public void setParentCommentId(String parentCommentId) {
        this.parentCommentId = parentCommentId;
        }
        public String getReply() {
        return reply;
        }

            public void setReply(String reply) {
        this.reply = reply;
        }
        public Date getReplyDate() {
        return replyDate;
        }

            public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
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
        public String getDataJson() {
        return dataJson;
        }

            public void setDataJson(String dataJson) {
        this.dataJson = dataJson;
        }

    @Override
    public String toString() {
    return "BaseComment{" +
            "id=" + id +
            ", resourceId=" + resourceId +
            ", resource=" + resource +
            ", content=" + content +
            ", star=" + star +
            ", imgs=" + imgs +
            ", parentCommentId=" + parentCommentId +
            ", reply=" + reply +
            ", replyDate=" + replyDate +
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
