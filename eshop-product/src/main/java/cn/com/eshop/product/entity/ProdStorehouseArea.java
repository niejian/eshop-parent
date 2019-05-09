package cn.com.eshop.product.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 产品库存地区关系表
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class ProdStorehouseArea implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 库存编号
            */
    private String storehouseCode;

            /**
            * 省份
            */
    private String provinceCode;

            /**
            * 省份
            */
    private String provinceName;

            /**
            * 城市
            */
    private String cityCode;

            /**
            * 城市
            */
    private String cityName;

            /**
            * 区县
            */
    private String areaCode;

            /**
            * 区县
            */
    private String areaName;

            /**
            * 镇
            */
    private String townCode;

            /**
            * 镇
            */
    private String townName;

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
        public String getStorehouseCode() {
        return storehouseCode;
        }

            public void setStorehouseCode(String storehouseCode) {
        this.storehouseCode = storehouseCode;
        }
        public String getProvinceCode() {
        return provinceCode;
        }

            public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
        }
        public String getProvinceName() {
        return provinceName;
        }

            public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
        }
        public String getCityCode() {
        return cityCode;
        }

            public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
        }
        public String getCityName() {
        return cityName;
        }

            public void setCityName(String cityName) {
        this.cityName = cityName;
        }
        public String getAreaCode() {
        return areaCode;
        }

            public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        }
        public String getAreaName() {
        return areaName;
        }

            public void setAreaName(String areaName) {
        this.areaName = areaName;
        }
        public String getTownCode() {
        return townCode;
        }

            public void setTownCode(String townCode) {
        this.townCode = townCode;
        }
        public String getTownName() {
        return townName;
        }

            public void setTownName(String townName) {
        this.townName = townName;
        }
        public String getRemark() {
        return remark;
        }

            public void setRemark(String remark) {
        this.remark = remark;
        }

    @Override
    public String toString() {
    return "ProdStorehouseArea{" +
            "id=" + id +
            ", storehouseCode=" + storehouseCode +
            ", provinceCode=" + provinceCode +
            ", provinceName=" + provinceName +
            ", cityCode=" + cityCode +
            ", cityName=" + cityName +
            ", areaCode=" + areaCode +
            ", areaName=" + areaName +
            ", townCode=" + townCode +
            ", townName=" + townName +
            ", remark=" + remark +
    "}";
    }
}
