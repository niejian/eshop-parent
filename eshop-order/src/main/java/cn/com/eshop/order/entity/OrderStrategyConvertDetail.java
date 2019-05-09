package cn.com.eshop.order.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 转品明细
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class OrderStrategyConvertDetail implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 策略编号
            */
    private String convertCode;

            /**
            * 产品编号(手动录入天猫店铺的产品编号)
            */
    private String productCode;

            /**
            * 产品数量
            */
    private Integer productNum;

            /**
            * 转品后产品编号
            */
    private String convertProductCode;

            /**
            * 转品后产品数量
            */
    private Integer convertNum;

        public Integer getId() {
        return id;
        }

            public void setId(Integer id) {
        this.id = id;
        }
        public String getConvertCode() {
        return convertCode;
        }

            public void setConvertCode(String convertCode) {
        this.convertCode = convertCode;
        }
        public String getProductCode() {
        return productCode;
        }

            public void setProductCode(String productCode) {
        this.productCode = productCode;
        }
        public Integer getProductNum() {
        return productNum;
        }

            public void setProductNum(Integer productNum) {
        this.productNum = productNum;
        }
        public String getConvertProductCode() {
        return convertProductCode;
        }

            public void setConvertProductCode(String convertProductCode) {
        this.convertProductCode = convertProductCode;
        }
        public Integer getConvertNum() {
        return convertNum;
        }

            public void setConvertNum(Integer convertNum) {
        this.convertNum = convertNum;
        }

    @Override
    public String toString() {
    return "OrderStrategyConvertDetail{" +
            "id=" + id +
            ", convertCode=" + convertCode +
            ", productCode=" + productCode +
            ", productNum=" + productNum +
            ", convertProductCode=" + convertProductCode +
            ", convertNum=" + convertNum +
    "}";
    }
}
