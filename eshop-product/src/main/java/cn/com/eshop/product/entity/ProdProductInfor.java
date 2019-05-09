package cn.com.eshop.product.entity;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 产品信息
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class ProdProductInfor implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 类别编号
            */
    private String categoryCode;

            /**
            * 品牌编号
            */
    private String brandCode;

            /**
            * 产品编号(sku)
            */
    private String productCode;

            /**
            * 规格型号:(产品编号+规格型号)确定唯一产品
            */
    private String specification;

            /**
            * 产品名称(对外)
            */
    private String productName;

            /**
            * 产品简称(对内)
            */
    private String productNameShort;

            /**
            * 产品类型:(字典：product_type)single_pro-单品，set_meal-套餐，virtual_pro-虚拟产品
            */
    private String productType;

            /**
            * 是否拆分:0否,1是（product_type=set_meal时才有用，允许套餐拆了发物流）
            */
    private Integer flagSetMealSplit;

            /**
            * 成本价(元)
            */
    private BigDecimal priceCost;

            /**
            * 市场价(元)
            */
    private BigDecimal priceMarket;

            /**
            * 销售价(元)
            */
    private BigDecimal priceRetail;

            /**
            * 损坏理赔价(元):默认为0取实际交易金额
            */
    private BigDecimal priceClaim;

            /**
            * 计量单位:(字典：product_unit)branch-支、bottle-瓶、set-套、group-组、box-箱
            */
    private String productUnit;

            /**
            * 是否赠品:0否,1是
            */
    private Integer flagPresent;

            /**
            * 保质期(天)
            */
    private Integer lifeCycle;

            /**
            * 产品条形码
            */
    private String barCodeOfProduct;

            /**
            * 外箱条形码
            */
    private String barCodeOfBox;

            /**
            * 关键字
            */
    private String keyWords;

            /**
            * 毛重(KG)
            */
    private BigDecimal weightOfGross;

            /**
            * 净重(KG):毛重-皮重(包装物的重量) 
            */
    private BigDecimal weightOfNet;

            /**
            * 体积(存放)m3
            */
    private BigDecimal depositVolume;

            /**
            * 长度(存放)m
            */
    private BigDecimal depositLength;

            /**
            * 宽度(存放)m
            */
    private BigDecimal depositWidth;

            /**
            * 高度(存放)m
            */
    private BigDecimal depositHeight;

            /**
            * 是否有图片:0否,1是
            */
    private Integer flagPicture;

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
        public String getCategoryCode() {
        return categoryCode;
        }

            public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
        }
        public String getBrandCode() {
        return brandCode;
        }

            public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
        }
        public String getProductCode() {
        return productCode;
        }

            public void setProductCode(String productCode) {
        this.productCode = productCode;
        }
        public String getSpecification() {
        return specification;
        }

            public void setSpecification(String specification) {
        this.specification = specification;
        }
        public String getProductName() {
        return productName;
        }

            public void setProductName(String productName) {
        this.productName = productName;
        }
        public String getProductNameShort() {
        return productNameShort;
        }

            public void setProductNameShort(String productNameShort) {
        this.productNameShort = productNameShort;
        }
        public String getProductType() {
        return productType;
        }

            public void setProductType(String productType) {
        this.productType = productType;
        }
        public Integer getFlagSetMealSplit() {
        return flagSetMealSplit;
        }

            public void setFlagSetMealSplit(Integer flagSetMealSplit) {
        this.flagSetMealSplit = flagSetMealSplit;
        }
        public BigDecimal getPriceCost() {
        return priceCost;
        }

            public void setPriceCost(BigDecimal priceCost) {
        this.priceCost = priceCost;
        }
        public BigDecimal getPriceMarket() {
        return priceMarket;
        }

            public void setPriceMarket(BigDecimal priceMarket) {
        this.priceMarket = priceMarket;
        }
        public BigDecimal getPriceRetail() {
        return priceRetail;
        }

            public void setPriceRetail(BigDecimal priceRetail) {
        this.priceRetail = priceRetail;
        }
        public BigDecimal getPriceClaim() {
        return priceClaim;
        }

            public void setPriceClaim(BigDecimal priceClaim) {
        this.priceClaim = priceClaim;
        }
        public String getProductUnit() {
        return productUnit;
        }

            public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
        }
        public Integer getFlagPresent() {
        return flagPresent;
        }

            public void setFlagPresent(Integer flagPresent) {
        this.flagPresent = flagPresent;
        }
        public Integer getLifeCycle() {
        return lifeCycle;
        }

            public void setLifeCycle(Integer lifeCycle) {
        this.lifeCycle = lifeCycle;
        }
        public String getBarCodeOfProduct() {
        return barCodeOfProduct;
        }

            public void setBarCodeOfProduct(String barCodeOfProduct) {
        this.barCodeOfProduct = barCodeOfProduct;
        }
        public String getBarCodeOfBox() {
        return barCodeOfBox;
        }

            public void setBarCodeOfBox(String barCodeOfBox) {
        this.barCodeOfBox = barCodeOfBox;
        }
        public String getKeyWords() {
        return keyWords;
        }

            public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
        }
        public BigDecimal getWeightOfGross() {
        return weightOfGross;
        }

            public void setWeightOfGross(BigDecimal weightOfGross) {
        this.weightOfGross = weightOfGross;
        }
        public BigDecimal getWeightOfNet() {
        return weightOfNet;
        }

            public void setWeightOfNet(BigDecimal weightOfNet) {
        this.weightOfNet = weightOfNet;
        }
        public BigDecimal getDepositVolume() {
        return depositVolume;
        }

            public void setDepositVolume(BigDecimal depositVolume) {
        this.depositVolume = depositVolume;
        }
        public BigDecimal getDepositLength() {
        return depositLength;
        }

            public void setDepositLength(BigDecimal depositLength) {
        this.depositLength = depositLength;
        }
        public BigDecimal getDepositWidth() {
        return depositWidth;
        }

            public void setDepositWidth(BigDecimal depositWidth) {
        this.depositWidth = depositWidth;
        }
        public BigDecimal getDepositHeight() {
        return depositHeight;
        }

            public void setDepositHeight(BigDecimal depositHeight) {
        this.depositHeight = depositHeight;
        }
        public Integer getFlagPicture() {
        return flagPicture;
        }

            public void setFlagPicture(Integer flagPicture) {
        this.flagPicture = flagPicture;
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
    return "ProdProductInfor{" +
            "id=" + id +
            ", categoryCode=" + categoryCode +
            ", brandCode=" + brandCode +
            ", productCode=" + productCode +
            ", specification=" + specification +
            ", productName=" + productName +
            ", productNameShort=" + productNameShort +
            ", productType=" + productType +
            ", flagSetMealSplit=" + flagSetMealSplit +
            ", priceCost=" + priceCost +
            ", priceMarket=" + priceMarket +
            ", priceRetail=" + priceRetail +
            ", priceClaim=" + priceClaim +
            ", productUnit=" + productUnit +
            ", flagPresent=" + flagPresent +
            ", lifeCycle=" + lifeCycle +
            ", barCodeOfProduct=" + barCodeOfProduct +
            ", barCodeOfBox=" + barCodeOfBox +
            ", keyWords=" + keyWords +
            ", weightOfGross=" + weightOfGross +
            ", weightOfNet=" + weightOfNet +
            ", depositVolume=" + depositVolume +
            ", depositLength=" + depositLength +
            ", depositWidth=" + depositWidth +
            ", depositHeight=" + depositHeight +
            ", flagPicture=" + flagPicture +
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
