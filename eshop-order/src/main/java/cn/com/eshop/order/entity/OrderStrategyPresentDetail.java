package cn.com.eshop.order.entity;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 赠品策略明细
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class OrderStrategyPresentDetail implements Serializable {

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
            * 金额满
            */
    private BigDecimal fullOrderPayment;

            /**
            * 数量满
            */
    private Integer fullOrderNum;

            /**
            * 产品编号
            */
    private String productCode;

            /**
            * 产品名称
            */
    private String productName;

            /**
            * 规格型号
            */
    private String specification;

            /**
            * 产品数量
            */
    private Integer productNum;

            /**
            * 赠送产品编号
            */
    private String toProductCode;

            /**
            * 赠送产品名称
            */
    private String toProductName;

            /**
            * 赠送规格型号
            */
    private String toSpecification;

            /**
            * 赠送产品数量
            */
    private Integer toProductNum;

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
        public BigDecimal getFullOrderPayment() {
        return fullOrderPayment;
        }

            public void setFullOrderPayment(BigDecimal fullOrderPayment) {
        this.fullOrderPayment = fullOrderPayment;
        }
        public Integer getFullOrderNum() {
        return fullOrderNum;
        }

            public void setFullOrderNum(Integer fullOrderNum) {
        this.fullOrderNum = fullOrderNum;
        }
        public String getProductCode() {
        return productCode;
        }

            public void setProductCode(String productCode) {
        this.productCode = productCode;
        }
        public String getProductName() {
        return productName;
        }

            public void setProductName(String productName) {
        this.productName = productName;
        }
        public String getSpecification() {
        return specification;
        }

            public void setSpecification(String specification) {
        this.specification = specification;
        }
        public Integer getProductNum() {
        return productNum;
        }

            public void setProductNum(Integer productNum) {
        this.productNum = productNum;
        }
        public String getToProductCode() {
        return toProductCode;
        }

            public void setToProductCode(String toProductCode) {
        this.toProductCode = toProductCode;
        }
        public String getToProductName() {
        return toProductName;
        }

            public void setToProductName(String toProductName) {
        this.toProductName = toProductName;
        }
        public String getToSpecification() {
        return toSpecification;
        }

            public void setToSpecification(String toSpecification) {
        this.toSpecification = toSpecification;
        }
        public Integer getToProductNum() {
        return toProductNum;
        }

            public void setToProductNum(Integer toProductNum) {
        this.toProductNum = toProductNum;
        }

    @Override
    public String toString() {
    return "OrderStrategyPresentDetail{" +
            "id=" + id +
            ", presentCode=" + presentCode +
            ", fullOrderPayment=" + fullOrderPayment +
            ", fullOrderNum=" + fullOrderNum +
            ", productCode=" + productCode +
            ", productName=" + productName +
            ", specification=" + specification +
            ", productNum=" + productNum +
            ", toProductCode=" + toProductCode +
            ", toProductName=" + toProductName +
            ", toSpecification=" + toSpecification +
            ", toProductNum=" + toProductNum +
    "}";
    }
}
