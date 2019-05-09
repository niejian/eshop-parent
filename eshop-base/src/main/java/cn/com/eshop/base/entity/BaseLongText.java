package cn.com.eshop.base.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 长文本
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class BaseLongText implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 来源
            */
    private String sourceTable;

            /**
            * ID
            */
    private String sourceTableId;

            /**
            * 参数
            */
    private String paramCode;

            /**
            * 参数
            */
    private String paramName;

            /**
            * 长文本
            */
    private String text;

        public Integer getId() {
        return id;
        }

            public void setId(Integer id) {
        this.id = id;
        }
        public String getSourceTable() {
        return sourceTable;
        }

            public void setSourceTable(String sourceTable) {
        this.sourceTable = sourceTable;
        }
        public String getSourceTableId() {
        return sourceTableId;
        }

            public void setSourceTableId(String sourceTableId) {
        this.sourceTableId = sourceTableId;
        }
        public String getParamCode() {
        return paramCode;
        }

            public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
        }
        public String getParamName() {
        return paramName;
        }

            public void setParamName(String paramName) {
        this.paramName = paramName;
        }
        public String getText() {
        return text;
        }

            public void setText(String text) {
        this.text = text;
        }

    @Override
    public String toString() {
    return "BaseLongText{" +
            "id=" + id +
            ", sourceTable=" + sourceTable +
            ", sourceTableId=" + sourceTableId +
            ", paramCode=" + paramCode +
            ", paramName=" + paramName +
            ", text=" + text +
    "}";
    }
}
