package cn.com.eshop.base.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * 行政区域县区信息表
    * </p>
*
* @author code4fun
* @since 2019-05-09
*/
    public class BaseArea implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String cityCode;

    private String areaCode;

    private String area;

        public Integer getId() {
        return id;
        }

            public void setId(Integer id) {
        this.id = id;
        }
        public String getCityCode() {
        return cityCode;
        }

            public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
        }
        public String getAreaCode() {
        return areaCode;
        }

            public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        }
        public String getArea() {
        return area;
        }

            public void setArea(String area) {
        this.area = area;
        }

    @Override
    public String toString() {
    return "BaseArea{" +
            "id=" + id +
            ", cityCode=" + cityCode +
            ", areaCode=" + areaCode +
            ", area=" + area +
    "}";
    }
}
