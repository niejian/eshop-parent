package cn.com.eshop.product.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 产品套餐明细
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class ProdProductInforDetail implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 套餐编号，对应prod_product_infor表中 product_type=2 的商品编号
            */
    private String packageCode;

            /**
            * 单品编号，对应prod_product_infor表中 product_type=1 的商品编号
            */
    private String productCode;

            /**
            * 产品数量
            */
    private Integer productNum;

            /**
            * 排序
            */
    private Integer orderNum;

            /**
            * 是否删除:0否,1是
            */
    private Integer flagDelete;

        public Integer getId() {
        return id;
        }

            public void setId(Integer id) {
        this.id = id;
        }
        public String getPackageCode() {
        return packageCode;
        }

            public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
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
        public Integer getOrderNum() {
        return orderNum;
        }

            public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
        }
        public Integer getFlagDelete() {
        return flagDelete;
        }

            public void setFlagDelete(Integer flagDelete) {
        this.flagDelete = flagDelete;
        }

    @Override
    public String toString() {
    return "ProdProductInforDetail{" +
            "id=" + id +
            ", packageCode=" + packageCode +
            ", productCode=" + productCode +
            ", productNum=" + productNum +
            ", orderNum=" + orderNum +
            ", flagDelete=" + flagDelete +
    "}";
    }
}
